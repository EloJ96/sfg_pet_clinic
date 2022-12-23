package weplus.sfg_pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import weplus.sfg_pet_clinic.model.Pet;

public interface PetRepository extends CrudRepository <Pet, Long> {
}
