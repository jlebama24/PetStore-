package fr.javaEE;



import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;


public class TestEval {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore"); // nom du persistence‑unit
        EntityManager em  = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Adresse de Winterfell PetStore
        Address adr = new Address("1", "Kingsroad", "00001", "Winterfell");

        // Le magasin, géré par Jon Snow
        PetStore store = new PetStore("Winterfell PetStore", "Jon Snow", adr);

        // Produits
        Product croquettesLoup = new Product(
                "WOLF‑001", "Croquettes pour loup géant",
                ProdType.FOOD, 35.0, store);

        Product plumeDragon = new Product(
                "DRA‑100", "Plume de dragon décorative",
                ProdType.ACCESSORY, 99.9, store);

        // Animaux
        Fish poissonTargaryen = new Fish(
                LocalDate.of(2024, 4, 17), "argent",
                store, FishLivEnv.SEA_WATER);

        Cat chatArya = new Cat(
                LocalDate.of(2023, 12, 1), "blanc",
                store, "ARY‑0001");

         // Persistance
        tx.begin();

        em.persist(store);             // cascade ALL => address aussi
        em.persist(croquettesLoup);
        em.persist(plumeDragon);
        em.persist(poissonTargaryen);
        em.persist(chatArya);

        tx.commit();

        /* --- 4. Vérification rapide -------------------------------------- */
        System.out.println("=== PetStores ===");
        em.createQuery("select s from PetStore s", PetStore.class)
                .getResultList().forEach(System.out::println);

        System.out.println("=== Produits ===");
        em.createQuery("select p from Product p", Product.class)
                .getResultList().forEach(System.out::println);

        System.out.println("=== Animaux ===");
        em.createQuery("select a from Animal a", Animal.class)
                .getResultList().forEach(System.out::println);

        /* --- 5. Nettoyage ------------------------------------------------- */
        em.close();
        emf.close();
    }
}
