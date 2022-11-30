package weplus.sfg_pet_clinic.services.map;

import weplus.sfg_pet_clinic.model.Pet;
import weplus.sfg_pet_clinic.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }
    @Override
    public void deleteById(Long id) {
      super.deleteById(id);
    }


}
