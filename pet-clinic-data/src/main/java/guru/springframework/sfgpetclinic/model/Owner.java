package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */

@Data
@EqualsAndHashCode(exclude={"pets"})
@Entity
@Table(name ="owners")
public class Owner extends Person {
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String  telephone;
}
