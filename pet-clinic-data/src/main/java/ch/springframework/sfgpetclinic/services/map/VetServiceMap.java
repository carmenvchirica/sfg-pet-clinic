package ch.springframework.sfgpetclinic.services.map;

import ch.springframework.sfgpetclinic.model.Vet;
import ch.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet,Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        Long id = object.getId();
        return super.save(id, object);
    }

    @Override
    public Vet findById(Long id) {
        return findById(id);
    }
}