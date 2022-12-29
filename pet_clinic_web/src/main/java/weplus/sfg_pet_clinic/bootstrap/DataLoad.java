package weplus.sfg_pet_clinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import weplus.sfg_pet_clinic.model.*;
import weplus.sfg_pet_clinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoad(OwnerService ownerService,
                    VetService vetService,
                    PetTypeService petTypeService,
                    SpecialityService specialityService,
                    VisitService visitService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    //-----------------------------------------------------------------------------------------------------

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    //-----------------------------------------------------------------------------------------------------

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded PetType.....");

//-----------------------------------------------------------------------------------------------------

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

        Visit dogVisit = new Visit();
        dogVisit.setPet(luigisDog);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Cane Bagnato");

        visitService.save(dogVisit);

//-----------------------------------------------------------------------------------------------------

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

        Visit catVisit = new Visit();
        catVisit.setPet(elenasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Gatto bagnato");

        visitService.save(catVisit);

        System.out.println("Loaded Owners.....");

//-----------------------------------------------------------------------------------------------------

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sol");
        vet1.setLastName("Barrueto");
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Grecia");
        vet2.setLastName("D'Ambrosio");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
