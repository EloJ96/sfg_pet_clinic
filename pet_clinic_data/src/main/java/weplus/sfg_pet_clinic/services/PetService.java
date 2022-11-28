package weplus.sfg_pet_clinic.services;

import weplus.sfg_pet_clinic.model.Owner;
import weplus.sfg_pet_clinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
