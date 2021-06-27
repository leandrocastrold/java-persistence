package examplehibernate.repository;

import examplehibernate.SFFighter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SFFighterRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public SFFighter findById(int id) {
        createManagers();
        SFFighter fighter = entityManager.find(SFFighter.class, id);
        closeManagers();
        return fighter;
    }

    public void save(SFFighter sfFighter) {
        createManagers();
        entityManager.getTransaction().begin();
        entityManager.persist(sfFighter);
        entityManager.getTransaction().commit();
        closeManagers();
    }

    public void delete(int id) {
        createManagers();
        entityManager.getTransaction().begin();
        SFFighter sfFighter = entityManager.find(SFFighter.class, id);
        entityManager.remove(sfFighter);
        entityManager.getTransaction().commit();
        closeManagers();
    }

    public void update(SFFighter sfFighter) {
        createManagers();
        entityManager.getTransaction().begin();
        entityManager.merge(sfFighter);
        entityManager.getTransaction().commit();
        closeManagers();
    }

    private void createManagers() {
        entityManagerFactory = Persistence.createEntityManagerFactory("sffighter");
        entityManager = entityManagerFactory.createEntityManager();
    }

    private void closeManagers() {
        entityManager.close();
        entityManagerFactory.close();
    }


}
