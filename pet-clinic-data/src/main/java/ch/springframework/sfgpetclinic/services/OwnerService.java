package ch.springframework.sfgpetclinic.services;

import ch.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService <Owner, Long> {

    Owner findByLastName(String lastName);

}
