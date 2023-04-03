package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetJpaService implements PetService {
    private final PetRepository petRepository;

    public PetJpaService(final PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        final Set<Pet> result = new HashSet<>();
        petRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Pet findById(final Long id) {
        final Optional<Pet> opt = petRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Pet save(final Pet element) {
        return petRepository.save(element);
    }

    @Override
    public void delete(final Pet element) {
        petRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        petRepository.deleteById(id);
    }
}
