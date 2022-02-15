package ch.springframework.sfgpetclinic.services;

import ch.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService <Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
