package ch.springframework.sfgpetclinic.services.map;

import ch.springframework.sfgpetclinic.model.Pet;
import ch.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        Long id = object.getId();
        return super.save(id, object);
    }

    @Override
    public Pet findById(Long id) {
        return findById(id);
    }
}
