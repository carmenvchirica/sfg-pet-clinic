package ch.springframework.sfgpetclinic.repositories;

import ch.springframework.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}