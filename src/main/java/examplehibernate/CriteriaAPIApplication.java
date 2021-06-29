package examplehibernate;

import examplehibernate.services.SFFighterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriteriaAPIApplication {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sffighter");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SFFighterService sfFighterService = new SFFighterService(entityManager);

        //GET
        //sfFighterService.getWithCriteria().stream().forEach(System.out::println);

        //GET BY ID
        // System.out.println(sfFighterService.getByIdWithCriteria(3));
        //GET BY ORDER
        //Ascendant
        //sfFighterService.getOrderedList(true).stream().forEach(System.out::println);
        //Descendant
        //sfFighterService.getOrderedList(false).stream().forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }

}
