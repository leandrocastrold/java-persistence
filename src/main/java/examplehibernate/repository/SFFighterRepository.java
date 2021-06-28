package examplehibernate.repository;

import examplehibernate.models.SFFighter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Locale;

public class SFFighterRepository {



    //JPA
    public SFFighter findById(int id, EntityManager entityManager) {
        SFFighter fighter = entityManager.find(SFFighter.class, id);
        return fighter;
    }

    public void save(SFFighter sfFighter, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.persist(sfFighter);
        entityManager.getTransaction().commit();
    }

    public void delete(int id, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        SFFighter sfFighter = entityManager.find(SFFighter.class, id);
        entityManager.remove(sfFighter);
        entityManager.getTransaction().commit();
    }

    public void update(SFFighter sfFighter, EntityManager entityManager) {
        entityManager.getTransaction().begin();
        entityManager.merge(sfFighter);
        entityManager.getTransaction().commit();
    }

    //JPQL

    public List<SFFighter> listAll(EntityManager entityManager) {
        String sqlCommand = "select a from SFFighter a";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .getResultList();
        return list;
    }

    public List<SFFighter> listByCountry(String country, EntityManager entityManager) {
        String sqlCommand = "select a from SFFighter a where a.country = :country";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("country", country)
                .getResultList();
        return list;
    }

    public List<SFFighter> listByGender(char gender, EntityManager entityManager) {
        String sqlCommand = "select a from SFFighter a where a.gender = :gender";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("gender", gender)
                .getResultList();
        return list;
    }


}
