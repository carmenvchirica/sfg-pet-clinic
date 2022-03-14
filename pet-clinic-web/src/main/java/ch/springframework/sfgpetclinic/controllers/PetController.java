package ch.springframework.sfgpetclinic.controllers;

import ch.springframework.sfgpetclinic.model.Owner;
import ch.springframework.sfgpetclinic.model.Pet;
import ch.springframework.sfgpetclinic.model.PetType;
import ch.springframework.sfgpetclinic.services.OwnerService;
import ch.springframework.sfgpetclinic.services.PetService;
import ch.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return "pets/createOrUpdatePetForm";
    }

    @PostMapping("/pets/new")
    public String createPet(@PathVariable("ownerId") Long ownerId, @ModelAttribute Pet pet, BindingResult result, ModelMap modelMap) throws Exception {
        Owner owner = ownerService.findById(ownerId);

        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }

        if(owner != null) {
            pet.setOwner(owner);
            owner.getPets().add(pet);
            if(result.hasErrors()) {
                modelMap.put("pet", pet);
                return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
            } else {
                petService.save(pet);
            }
        } else {
            throw new Exception("Can not find owner by id:" + ownerId);
        }

        return "redirect:/owners/" + ownerId;
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model) {
        model.addAttribute("pet", petService.findById(petId));
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(/*@Valid */Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        } else {
            // check if you find pet for owner in database
            Optional<Pet> foundPetOptional = owner.getPets().stream().filter(p -> p.getId() == pet.getId()).findFirst();

            if(foundPetOptional.isPresent()) {
                Pet foundPet = foundPetOptional.get();
                foundPet.setName(pet.getName());
                foundPet.setBirthDate(pet.getBirthDate());
                foundPet.setVisits(pet.getVisits());
                foundPet.setPetType(pet.getPetType());
                foundPet.setOwner(owner);
                ownerService.save(owner);
                return "redirect:/owners/" + owner.getId();
            } else {
                throw new RuntimeException("No pet found with id: " + pet.getId());
            }
        }
    }

}
