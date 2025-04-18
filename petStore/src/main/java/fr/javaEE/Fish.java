package fr.javaEE;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {}
    public Fish(LocalDate birth, String couleur,
                PetStore store, FishLivEnv env) {
        super(birth, couleur, store);
        this.livingEnv = env;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "livingEnv=" + livingEnv +
                '}';
    }
}
