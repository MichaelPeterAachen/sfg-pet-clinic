package guru.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 7/13/18.
 */
public class Owner extends Person {
    private Set<Pet> pets = new HashSet<>();
    private Owner owner;

    private String address, city, telephone;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(final Set<Pet> pets) {
        this.pets = pets;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
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
