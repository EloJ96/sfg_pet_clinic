package weplus.sfg_pet_clinic.services;

import weplus.sfg_pet_clinic.model.PetType;
import weplus.sfg_pet_clinic.model.Speciality;

import java.util.Set;

public interface SpecialityService extends CrudService<Speciality, Long>{

    Speciality findById(Long id);

    Speciality save(Speciality speciality);

    Set<Speciality> findAll();

}
