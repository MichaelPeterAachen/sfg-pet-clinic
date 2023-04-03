package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class SpecialityJpaService implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    @Override
    public Set<Speciality> findAll() {
        final Set<Speciality> result = new HashSet<>();
        specialityRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> opt = specialityRepository.findById(id);
        return opt.orElse(null);
    }


    @Override
    public Speciality save(final Speciality element) {
        return specialityRepository.save(element);
    }

    @Override
    public void delete(final Speciality element) {
        specialityRepository.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        specialityRepository.deleteById(id);
    }
}
