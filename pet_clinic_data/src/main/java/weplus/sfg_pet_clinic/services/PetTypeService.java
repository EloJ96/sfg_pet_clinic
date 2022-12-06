package weplus.sfg_pet_clinic.services;


import weplus.sfg_pet_clinic.model.PetType;

import java.util.Set;

public interface PetTypeService extends CrudService<PetType, Long> {

    PetType findById(Long id);

    PetType save(PetType petType);

    Set<PetType> findAll();

}
