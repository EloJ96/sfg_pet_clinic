package weplus.sfg_pet_clinic.services.springdatajpa;

import weplus.sfg_pet_clinic.model.Speciality;
import weplus.sfg_pet_clinic.repositories.SpecialityRepository;
import weplus.sfg_pet_clinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialityRepository.save(object);
    }



    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
