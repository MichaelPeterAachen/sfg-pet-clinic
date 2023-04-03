package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitJpaService implements VisitService {
    private final VisitRepository visitRepository;

    @Override
    public Set<Visit> findAll() {
        final Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(final Long id) {
        final Optional<Visit> opt = visitRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Visit save(final Visit element) {
        return visitRepository.save(element);
    }

    @Override
    public void delete(final Visit element) {
        visitRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        visitRepository.deleteById(id);
    }
}
