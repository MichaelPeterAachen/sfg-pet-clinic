package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"map","default"})
@RequiredArgsConstructor
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    private PetService petService;

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit element) {
        super.delete(element);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit == null) {
            return null;
        }
        if (visit.getPet() == null) {
            throw new RuntimeException("No pet defined");
        }
        if (visit.getPet().getId() == null) {
            throw new RuntimeException("Pet not persisted, yet");
        }
        if (visit.getPet().getOwner() == null) {
            throw new RuntimeException("No pet owner defined");
        }
        if (visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Pet owner not persisted, yet");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
