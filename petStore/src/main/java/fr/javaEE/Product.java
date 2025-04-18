package fr.javaEE;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;

    private double price;

    // Il peut y avoir plusieurs produits dans un petStore
    @ManyToOne
    @JoinColumn(name = "petStore_id")
    private PetStore store;

    public Product() {}
    public Product(String code, String label, ProdType type,
                   double price, PetStore store) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public ProdType getType() {
        return type;
    }
    public void setType(ProdType type) { this.type = type; }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public PetStore getStore() {
        return store;
    }
    public void setStore(PetStore store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", store=" + store +
                '}';
    }
}
