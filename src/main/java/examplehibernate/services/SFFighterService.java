package examplehibernate.services;

import examplehibernate.models.SFFighter;
import examplehibernate.repository.SFFighterRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class SFFighterService {


    private SFFighterRepository repository;

    public SFFighterService(EntityManager entityManager) {
     repository = new SFFighterRepository(entityManager);
    }



    public List<SFFighter> getFighters(EntityManager entityManager) {
         return repository.listAll();
    }

    public List<SFFighter> getFightersByCountry(String country, EntityManager entityManager) {
        return repository.listByCountry(country);
    }

    public List<SFFighter> getFightersByGender(char gender, EntityManager entityManager) {
        return repository.listByGender(gender);
    }

    public SFFighter getFighterById(int fighterId, EntityManager entityManager) {
        return repository.findById(fighterId);
    }

    public void insertSFFighter(SFFighter sfFighter, EntityManager entityManager) {
        repository.save(sfFighter);
    }

    public void deleteFighter(int id,  EntityManager entityManager){
        repository.delete(id);
    }

    public void updateFighter(int id, SFFighter sfFighter,  EntityManager entityManager) {
       SFFighter fighterToUpdate = repository.findById(id);
       fighterToUpdate.setName(sfFighter.getName());
       fighterToUpdate.setCountry(sfFighter.getCountry());
       fighterToUpdate.setGender(sfFighter.getGender());
       repository.update(fighterToUpdate);
    }

    //CRITERIA API

    public List<SFFighter> getWithCriteria() {
        return repository.getWithCriteria();
    }

    public SFFighter getByIdWithCriteria(int id) {
        return repository.getByIdWithCriteria(id);
    }

    public List<SFFighter> getOrderedList(boolean isAscendant) {
        return  repository.getOrderedList(isAscendant);
    }



}
