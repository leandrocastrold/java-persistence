package examplehibernate;

import examplehibernate.services.SFFighterService;

public class HibernateApplication {

    public static void main(String[] args) {

        SFFighterService sfFighterService = new SFFighterService();

        //CRUD
        // Get By ID
        //sfFighterService.getFighterById(id);

        //Insert new fighter
        //sfFighterService.insertSFFighter(sfFighter);

        //Delete Fighter
        //sfFighterService.deleteFighter(id);

        //Update Fighter
        //sfFighterService.updateFighter(id, sfFighter);
    }
}
