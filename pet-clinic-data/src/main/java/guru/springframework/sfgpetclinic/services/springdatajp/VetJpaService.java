package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        final Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(final Long id) {
        final Optional<Vet> opt = vetRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Vet save(final Vet element) {
        return vetRepository.save(element);
    }

    @Override
    public void delete(final Vet element) {
        vetRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        vetRepository.deleteById(id);
    }
}
