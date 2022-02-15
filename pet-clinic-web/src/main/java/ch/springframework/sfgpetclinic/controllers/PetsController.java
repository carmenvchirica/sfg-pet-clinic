package ch.springframework.sfgpetclinic.controllers;

import ch.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetsController {

    private PetService petService;

    public PetsController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"/pets", "/pets/index", "/pets/index.html"})
    public String listPets(Model model) {
        model.addAttribute("pets", petService.findAll());
        return "pets/index";
    }
}
