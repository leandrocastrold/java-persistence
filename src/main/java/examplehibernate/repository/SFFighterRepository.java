package examplehibernate.repository;

import examplehibernate.models.SFFighter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class SFFighterRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    //JPA
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

    //JPQL

    public List<SFFighter> listAll() {
        createManagers();
        String sqlCommand = "select a from SFFighter a";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .getResultList();
        closeManagers();
        return list;
    }

    public List<SFFighter> listByCountry(String country) {
        createManagers();
        String sqlCommand = "select a from SFFighter a where a.country = :country";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("country", country)
                .getResultList();
        closeManagers();
        return list;
    }

    public List<SFFighter> listByGender(char gender) {
        createManagers();
        String sqlCommand = "select a from SFFighter a where a.gender = :gender";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("gender", gender)
                .getResultList();
        closeManagers();
        return list;
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
