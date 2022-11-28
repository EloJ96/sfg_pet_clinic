package weplus.sfg_pet_clinic.services;

import weplus.sfg_pet_clinic.model.Owner;
import weplus.sfg_pet_clinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
