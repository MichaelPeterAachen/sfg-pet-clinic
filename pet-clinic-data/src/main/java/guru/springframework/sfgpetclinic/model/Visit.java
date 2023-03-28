package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.time.LocalDate;

public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    public Visit() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(final Pet pet) {
        this.pet = pet;
    }
}
