package weplus.sfg_pet_clinic.repositories;

import org.springframework.data.repository.CrudRepository;
import weplus.sfg_pet_clinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
