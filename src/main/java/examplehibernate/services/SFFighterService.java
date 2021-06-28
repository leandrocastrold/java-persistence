package examplehibernate.services;

import examplehibernate.models.SFFighter;
import examplehibernate.repository.SFFighterRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class SFFighterService {

    private SFFighterRepository repository = new SFFighterRepository();

    public List<SFFighter> getFighters(EntityManager entityManager) {
         return repository.listAll(entityManager);
    }

    public List<SFFighter> getFightersByCountry(String country, EntityManager entityManager) {
        return repository.listByCountry(country, entityManager);
    }

    public List<SFFighter> getFightersByGender(char gender, EntityManager entityManager) {
        return repository.listByGender(gender, entityManager );
    }

    public SFFighter getFighterById(int fighterId, EntityManager entityManager) {
        return repository.findById(fighterId, entityManager);
    }

    public void insertSFFighter(SFFighter sfFighter, EntityManager entityManager) {
        repository.save(sfFighter, entityManager);
    }

    public void deleteFighter(int id,  EntityManager entityManager){
        repository.delete(id, entityManager);
    }

    public void updateFighter(int id, SFFighter sfFighter,  EntityManager entityManager) {
       SFFighter fighterToUpdate = repository.findById(id, entityManager);
       fighterToUpdate.setName(sfFighter.getName());
       fighterToUpdate.setCountry(sfFighter.getCountry());
       fighterToUpdate.setGender(sfFighter.getGender());
       repository.update(fighterToUpdate, entityManager);
    }

}
