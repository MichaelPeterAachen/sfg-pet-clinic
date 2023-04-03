package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    @Override
    public Set<Owner> findAll() {
        final Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(final Long id) {
        final Optional<Owner> ownerOpt = ownerRepository.findById(id);
        return ownerOpt.orElse(null);
    }

    @Override
    public Owner save(final Owner element) {
        return ownerRepository.save(element);
    }

    @Override
    public void delete(final Owner element) {
        ownerRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
