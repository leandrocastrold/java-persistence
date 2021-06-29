package examplehibernate;

import examplehibernate.models.SFFighter;
import examplehibernate.services.SFFighterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPQLApplication {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sffighter");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SFFighterService sfFighterService = new SFFighterService(entityManager);

        // Queries using JPQL - Java Persistence Query Language

        // To list all fighters
       // List<SFFighter> fighters = sfFighterService.getFighters(entityManager);

        // To list fighter by country
        //List<SFFighter> fighters = sfFighterService.getFightersByCountry("Brazil", entityManager);

        // To list fighter by gender
        //List<SFFighter> fighters = sfFighterService.getFightersByGender('m', entityManager);

      // fighters.stream().forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }

}
