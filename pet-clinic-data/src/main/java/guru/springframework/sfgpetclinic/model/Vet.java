package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
public class Vet extends Person {
    private Set<Specialitiy> specialities;

    public Set<Specialitiy> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final Set<Specialitiy> specialities) {
        this.specialities = specialities;
    }
}
