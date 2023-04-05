package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialityService specialityService, final VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(final String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        System.out.println("AddPet Types");
        final PetType dogType = addPetTypeToRepository("Dog");
        final PetType catType = addPetTypeToRepository("Cat");

        System.out.println("Add Owners and Vets");

        final Owner owner1 = createOwner("Michael", "Pezer", "P-Street", "P-city", "P-Number");
        final Pet dog = addPetToOwner(dogType, owner1, "Birdie");
        addOwnerToRepository(owner1, dog);

        final Owner owner2 = createOwner("Michael", "J", "J-Street", "Jcity", "J-Number");
        final Pet cat = addPetToOwner(dogType, owner2, "Charlie");
        addOwnerToRepository(owner2, cat);

        System.out.println("Add Vets and Specialities");

        final Speciality speciality1 = addSpecialityToRepository("radiology");
        final Speciality speciality2 = addSpecialityToRepository("surgery");

        addVetToRepository("Sam", "Axe", speciality1);
        addVetToRepository("Jessie", "Porter", speciality2);

        System.out.println("Add visits");

        addVisitToRepository("A first visit", cat);

        addVisitToRepository("A second visit", dog);
    }

    private void addVisitToRepository(final String description, final Pet cat) {
        final Visit visit1 = new Visit();
        visit1.setDate(LocalDate.now());
        visit1.setDescription(description);
        visit1.setPet(cat);
        visitService.save(visit1);
    }

    private void addVetToRepository(final String firstName, final String lastName, final Speciality speciality1) {
        final Vet vet1 = new Vet();
        vet1.setFirstName(firstName);
        vet1.setLastName(lastName);
        vet1.getSpecialities().add(speciality1);
        vetService.save(vet1);
    }

    private Speciality addSpecialityToRepository(final String description) {
        final Speciality speciality = new Speciality();
        speciality.setDescription(description);
        specialityService.save(speciality);
        return speciality;
    }

    private void addOwnerToRepository(final Owner owner, final Pet pet) {
        owner.getPets().add(pet);
        ownerService.save(owner);
    }

    private PetType addPetTypeToRepository(final String type) {
        final PetType petType = new PetType();
        petType.setName(type);
        final PetType savedPetType = petTypeService.save(petType);
        return savedPetType;
    }

    private static Pet addPetToOwner(final PetType petType, final Owner owner, final String name) {
        final Pet pet = new Pet();
        pet.setPetType(petType);
        pet.setOwner(owner);
        pet.setName(name);
        pet.setBirthDate(LocalDate.now());
        return pet;
    }

    private static Owner createOwner(final String firstName, final String lastName, final String address, final String city, final String telephone) {
        final Owner owner1 = new Owner();
        owner1.setFirstName(firstName);
        owner1.setLastName(lastName);
        owner1.setAddress(address);
        owner1.setCity(city);
        owner1.setTelephone(telephone);
        return owner1;
    }
}
