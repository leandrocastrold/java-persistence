package examplejdbc;

import examplejdbc.classes.MKFighter;
import examplejdbc.dao.FightersDAO;

import java.sql.SQLException;

public class JDBCApplication {
    public static void main(String[] args) throws SQLException {

        FightersDAO fightersDAO = new FightersDAO();
        MKFighter mkFighter = new MKFighter("Lord Raiden","Elder God", "Staff");

        //Create table mkfighters if it not exists
        fightersDAO.createTableIfNotExists();

        //GET
        // fightersDAO.get().stream().forEach(System.out::println);

        //GET BY ID
        //System.out.println(fightersDAO.getById(1));

        //CREATE
        //fightersDAO.create(mkFighter);

        //DELETE
        //fightersDAO.delete(1);

        //UPDATE
        //fightersDAO.update(1, mkFighter);
    }
}
