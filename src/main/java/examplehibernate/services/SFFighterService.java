package examplehibernate.services;

import examplehibernate.SFFighter;
import examplehibernate.repository.SFFighterRepository;

public class SFFighterService {

    private SFFighterRepository repository = new SFFighterRepository();

    public SFFighter getFighter(int fighterId) {
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
