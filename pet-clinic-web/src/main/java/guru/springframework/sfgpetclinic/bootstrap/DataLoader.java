package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
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

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
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

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);
    }
}
