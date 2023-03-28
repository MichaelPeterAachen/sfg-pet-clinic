package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {


    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality specialitiy) {
        super.delete(specialitiy);
    }

    @Override
    public Speciality save(Speciality specialitiy) {
        return super.save(specialitiy);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
