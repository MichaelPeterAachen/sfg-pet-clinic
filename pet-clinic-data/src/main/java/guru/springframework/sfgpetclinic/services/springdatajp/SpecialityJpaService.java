package guru.springframework.sfgpetclinic.services.springdatajp;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialityJpaService implements SpecialityService {
    private final SpecialityService specialityService;

    public SpecialityJpaService(final SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Speciality> findAll() {
        final Set<Speciality> result = new HashSet<>();
        specialityService.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Speciality findById(final Long id) {
        return specialityService.findById(id);
    }

    @Override
    public Speciality save(final Speciality element) {
        return specialityService.save(element);
    }

    @Override
    public void delete(final Speciality element) {
        specialityService.delete(element);
    }

    @Override
    public void deleteById(final Long id) {
        specialityService.deleteById(id);
    }
}
