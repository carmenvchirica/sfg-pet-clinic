package ch.springframework.sfgpetclinic.services.map;

import ch.springframework.sfgpetclinic.model.Owner;
import ch.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner,Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        Long id = object.getId();
        return super.save(id, object);
    }

    @Override
    public Owner findById(Long id) {
        return findById(id);
    }
}
