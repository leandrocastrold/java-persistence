package examplehibernate;

import examplehibernate.services.SFFighterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApplication {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sffighter");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SFFighterService sfFighterService = new SFFighterService();

        //CRUD
        // Get By ID
        //System.out.println(sfFighterService.getFighterById(id, entityManager));

        //Insert new fighter
        //sfFighterService.insertSFFighter(sfFighter, entityManager);

        //Delete Fighter
        //sfFighterService.deleteFighter(id, entityManager);

        //Update Fighter
        //sfFighterService.updateFighter(id, sfFighter, entityManager);

        entityManager.close();
        entityManagerFactory.close();
    }
}
