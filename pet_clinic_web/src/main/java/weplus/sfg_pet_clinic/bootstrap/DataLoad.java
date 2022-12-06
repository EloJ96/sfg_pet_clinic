package weplus.sfg_pet_clinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import weplus.sfg_pet_clinic.model.Owner;
import weplus.sfg_pet_clinic.model.Pet;
import weplus.sfg_pet_clinic.model.PetType;
import weplus.sfg_pet_clinic.model.Vet;
import weplus.sfg_pet_clinic.services.OwnerService;
import weplus.sfg_pet_clinic.services.PetTypeService;
import weplus.sfg_pet_clinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoad(OwnerService ownerService,
                    VetService vetService,
                    PetTypeService petTypeService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetType.....");


        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Luigi");
        owner1.setLastName("Maestri");
        owner1.setAddress("Via quercia nascosta 17");
        owner1.setCity("Monza");
        owner1.setTelephone("3920584995");

        Pet luigisDog = new Pet();
        luigisDog.setPetType(savedDogPetType);
        luigisDog.setOwner(owner1);
        luigisDog.setBirthDate(LocalDate.now());
        luigisDog.setName("Laica");
        owner1.getPets().add(luigisDog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Elena");
        owner2.setLastName("Monnalisa");
        owner2.setAddress("Corso Alcide DeGasperi 31");
        owner2.setCity("Mirabilandia");
        owner2.setTelephone("3376039584");

        Pet elenasCat = new Pet();
        elenasCat.setPetType(savedCatPetType);
        elenasCat.setOwner(owner2);
        elenasCat.setBirthDate(LocalDate.now());
        elenasCat.setName("Kuki");
        owner2.getPets().add(elenasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sol");
        vet1.setLastName("Barrueto");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Grecia");
        vet2.setLastName("D'Ambrosio");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");

    }
}
