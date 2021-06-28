package examplehibernate;

import examplehibernate.models.SFFighter;
import examplehibernate.services.SFFighterService;

import java.util.List;

public class JPQLApplication {

    public static void main(String[] args) {

        SFFighterService sfFighterService = new SFFighterService();

        // Queries using JPQL - Java Persistence Query Language

        // To list all fighers
        // List<SFFighter> fighters = sfFighterService.getfighters();

        // To list fighter by country
        //List<SFFighter> fighters = sfFighterService.getFightersByCountry("Brazil");

        // To list fighter by gender
        //List<SFFighter> fighters = sfFighterService.getFightersByGender('m');

       // fighters.stream().forEach(System.out::println);

    }

}
