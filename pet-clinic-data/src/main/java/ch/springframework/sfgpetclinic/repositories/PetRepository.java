package ch.springframework.sfgpetclinic.repositories;

import ch.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}