package examplehibernate.repository;

import examplehibernate.models.SFFighter;
import jdk.dynalink.linker.LinkerServices;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;

public class SFFighterRepository {

    EntityManager entityManager;
    public SFFighterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //JPA
    public SFFighter findById(int id) {
        SFFighter fighter = entityManager.find(SFFighter.class, id);
        return fighter;
    }

    public void save(SFFighter sfFighter) {
        entityManager.getTransaction().begin();
        entityManager.persist(sfFighter);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        entityManager.getTransaction().begin();
        SFFighter sfFighter = entityManager.find(SFFighter.class, id);
        entityManager.remove(sfFighter);
        entityManager.getTransaction().commit();
    }

    public void update(SFFighter sfFighter) {
        entityManager.getTransaction().begin();
        entityManager.merge(sfFighter);
        entityManager.getTransaction().commit();
    }

    //JPQL

    public List<SFFighter> listAll() {
        String sqlCommand = "select a from SFFighter a";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .getResultList();
        return list;
    }

    public List<SFFighter> listByCountry(String country) {
        String sqlCommand = "select a from SFFighter a where a.country = :country";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("country", country)
                .getResultList();
        return list;
    }

    public List<SFFighter> listByGender(char gender) {
        String sqlCommand = "select a from SFFighter a where a.gender = :gender";
        List<SFFighter> list = entityManager
                .createQuery(sqlCommand, SFFighter.class)
                .setParameter("gender", gender)
                .getResultList();
        return list;
    }


    public List<SFFighter> getWithCriteria() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SFFighter.class);

        Root<SFFighter> root = criteriaQuery.from(SFFighter.class);
        List<SFFighter> fighters = entityManager.createQuery(criteriaQuery).getResultList();
        return  fighters;
    }

    public SFFighter getByIdWithCriteria(int id) {
       CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
       CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SFFighter.class);
       Root<SFFighter> root = criteriaQuery.from(SFFighter.class);
       criteriaQuery.select(root);
       criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

       SFFighter sfFighter = (SFFighter) entityManager.createQuery(criteriaQuery).getSingleResult();

       return  sfFighter;
    }

    public List<SFFighter> getOrderedList(boolean isAscendant) {
     CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
     CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(SFFighter.class);
     Root<SFFighter> root = criteriaQuery.from(SFFighter.class);
     criteriaQuery.select(root);

     if (isAscendant) {
         criteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
     } else {
         criteriaQuery.orderBy(criteriaBuilder.desc(root.get("name")));
     }

     List<SFFighter> sfFighters = entityManager
             .createQuery(criteriaQuery)
             .getResultList();

     return sfFighters;
    }
}
