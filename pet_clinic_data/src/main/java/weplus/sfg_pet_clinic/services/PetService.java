package weplus.sfg_pet_clinic.services;

import weplus.sfg_pet_clinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
