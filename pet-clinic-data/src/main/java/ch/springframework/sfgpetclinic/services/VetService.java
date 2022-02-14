package ch.springframework.sfgpetclinic.services;

import ch.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetService  extends CrudRepository<Vet, Long> {

}
