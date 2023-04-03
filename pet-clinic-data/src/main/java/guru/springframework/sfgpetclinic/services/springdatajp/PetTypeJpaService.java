package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    @Override
    public Set<PetType> findAll() {
        final Set<PetType> result = new HashSet<>();
        petTypeRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public PetType findById(final Long id) {
        final Optional<PetType> opt = petTypeRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public PetType save(final PetType element) {
        return petTypeRepository.save(element);
    }

    @Override
    public void delete(final PetType element) {
        petTypeRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}
