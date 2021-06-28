package examplehibernate.services;

import examplehibernate.models.SFFighter;
import examplehibernate.repository.SFFighterRepository;

import java.util.List;

public class SFFighterService {

    private SFFighterRepository repository = new SFFighterRepository();

    public List<SFFighter> getfighters() {
         return repository.listAll();
    }

    public List<SFFighter> getFightersByCountry(String country) {
        return repository.listByCountry(country);
    }

    public List<SFFighter> getFightersByGender(char gender) {
        return repository.listByGender(gender);
    }

    public SFFighter getFighterById(int fighterId) {
        return repository.findById(fighterId);
    }

    public void insertSFFighter(SFFighter sfFighter) {
     repository.save(sfFighter);
    }

    public void deleteFighter(int id){
        repository.delete(id);
    }

    public void updateFighter(int id, SFFighter sfFighter) {
       SFFighter fighterToUpdate = repository.findById(id);
       fighterToUpdate.setName(sfFighter.getName());
       fighterToUpdate.setCountry(sfFighter.getCountry());
       fighterToUpdate.setGender(sfFighter.getGender());
       repository.update(fighterToUpdate);
    }

}
