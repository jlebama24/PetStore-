# 🐾 PetStore – JPA / Hibernate demo

> Mini‑application Java 17 + Hibernate 6 pour gérer une animalerie (magasins, produits, animaux). Conçue pour l’évaluation « TP PetStore ».



## Fonctionnalités
- Mapping complet JPA  (`@Entity`, relations, héritage `JOINED`).
- Persistance auto via Hibernate 6 (`hibernate.hbm2ddl.auto=update`).
- Insertion d’exemples *Game of Thrones* (runner).
- Requêtes Spring Data JPA : produits par code, animaux par magasin.

## Stack technique
| Outil | Version |
|-------|---------|
| Java  | 17 / 21 |
| Maven | 3.9.x   |
| Hibernate ORM | 6.3.x |
| Jakarta Persistence API | 3.1 |
| MariaDB | ≥ 10.6 |

## Prérequis
```bash
mariadb --version   # serveur local sur 3306
java -version       # JDK 17+ (Adoptium, OpenJDK…)
mvn -version        # Maven 3.8+
```

## Installation & lancement
```bash
# 1. Clone
git clone https://github.com/yourname/petstore.git
cd petstore

# 2. Configuration BDD (src/main/resources/application.properties)
spring.datasource.url=jdbc:mariadb://localhost:3306/petstore
spring.datasource.username=root
spring.datasource.password=yourpwd

# 3. Build & run (Spring Boot)
mvn spring-boot:run
#   ou
mvn clean package && java -jar target/petstore-1.0.jar
```

> Les tables sont créées automatiquement au premier démarrage, puis peuplées par le *CommandLineRunner*.

## Structure du projet
```
src/
 └─ main/
     ├─ java/
     │   └─ fr/javaEE/petstore/
     │        ├─ domain/      # entités JPA
     │        ├─ repository/  # interfaces JpaRepository
     │        ├─ service/     # logique métier (facultatif)
     │        └─ runner/      # TestPetStore.java
     └─ resources/
         ├─ application.properties (ou META-INF/persistence.xml)
         └─ schema.sql / data.sql 
```

## Runner d’insertion
Le fichier `TestPetStore.java` insère :
- 1 `PetStore` + `Address`
- 2 `Product` (*Croquettes* / *Plume de dragon*)
- 1 `Fish` et 1 `Cat`

Les requêtes JPQL affichent les données insérées.

## Tests unitaires
Ajoutez vos tests JUnit 5 sous `src/test/java` :
```java
@DataJpaTest
class ProductRepoTest { … }
```

## Auteurs
- Lebama Jacques – jlebama.ir2026@esaip.org
- Encadrant : **S. Sy** (`@ssy-esaip`)


