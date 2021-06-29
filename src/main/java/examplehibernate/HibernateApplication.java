package examplehibernate;

import examplehibernate.services.SFFighterService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApplication {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sffighter");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SFFighterService sfFighterService = new SFFighterService(entityManager);

        //CRUD
        // Get By ID
        //System.out.println(sfFighterService.getFighterById(id));

        //Insert new fighter
        //sfFighterService.insertSFFighter(sfFighter);

        //Delete Fighter
        //sfFighterService.deleteFighter(id);

        //Update Fighter
        //sfFighterService.updateFighter(id, sfFighter);

        entityManager.close();
        entityManagerFactory.close();
    }
}
