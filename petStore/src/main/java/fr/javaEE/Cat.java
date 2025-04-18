package fr.javaEE;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Cat extends Animal {

    private String chipId;

    public Cat() {}
    public Cat(LocalDate birth, String couleur,
               PetStore store, String chipId) {
        super(birth, couleur, store);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "chipId='" + chipId + '\'' +
                '}';
    }
}
