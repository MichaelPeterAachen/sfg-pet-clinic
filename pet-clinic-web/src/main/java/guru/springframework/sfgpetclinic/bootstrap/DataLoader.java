package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialityService specialityService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("AddPet Types");
        PetType dogType = new PetType();
        dogType.setName("Dog");
        PetType savedDogType = petTypeService.save(dogType);


        PetType catType = new PetType();
        catType.setName("Cat");
        PetType savedCatType = petTypeService.save(catType);


        System.out.println("Add Owners and Vets");
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("P");
        owner1.setAddress("P-Street");
        owner1.setCity("P-city");
        owner1.setTelephone("P-Number");

        Pet dog = new Pet();
        dog.setPetType(savedDogType);
        dog.setOwner(owner1);
        dog.setName("Birdie");
        dog.setBirthDate(LocalDate.now());

        owner1.getPets().add(dog);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("J");
        owner2.setAddress("J-Street");
        owner2.setCity("Jcity");
        owner2.setTelephone("J-Number");

        Pet cat = new Pet();
        cat.setPetType(savedDogType);
        cat.setOwner(owner2);
        cat.setName("Charlie");
        cat.setBirthDate(LocalDate.now());

        owner2.getPets().add(cat);

        ownerService.save(owner2);

        Speciality speciality1 = new Speciality();
        speciality1.setDescription("radiology");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(speciality1);
        vetService.save(vet1);

        Speciality speciality2 = new Speciality();
        speciality2.setDescription("surgery");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(speciality2);
        vetService.save(vet2);
    }
}
