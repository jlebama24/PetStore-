package fr.javaEE;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String street;
    private String zipCode;
    private String city;

    // 1 Adreesse correspond à un store
    @OneToOne(mappedBy = "address")
    private PetStore store;

    public Address() {
    }

    public Address(String number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

}
