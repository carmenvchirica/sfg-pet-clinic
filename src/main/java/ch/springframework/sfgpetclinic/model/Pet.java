package ch.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet {
    private PerType perType;
    private Owner owner;
    private LocalDate birthdate;

    public PerType getPerType() {
        return perType;
    }

    public void setPerType(PerType perType) {
        this.perType = perType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
