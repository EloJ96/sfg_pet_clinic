package weplus.sfg_pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import weplus.sfg_pet_clinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
