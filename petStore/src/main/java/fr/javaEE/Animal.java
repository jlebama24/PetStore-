package fr.javaEE;
import fr.javaEE.PetStore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal implements Serializable {
    // Classe abstraite qui va servir à implementer les méthodes liées aux animaux (poissons et chats)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate birth;
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "store")
    private PetStore store;

    public Animal() {}
    public Animal(LocalDate birth, String couleur, PetStore store) {
        this.birth = birth;
        this.couleur = couleur;
        this.store = store;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public PetStore getStore() {
        return store;
    }
    public void setStore(PetStore store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", birth=" + birth +
                ", couleur='" + couleur + '\'' +
                ", store=" + store +
                '}';
    }
}
