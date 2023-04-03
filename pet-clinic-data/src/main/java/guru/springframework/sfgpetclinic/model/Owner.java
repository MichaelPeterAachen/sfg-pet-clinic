package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
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

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(final Set<Pet> pets) {
        this.pets = pets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }
}
