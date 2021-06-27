package examplejdbc.dao;

import examplejdbc.ConnectionFactory;
import examplejdbc.classes.MKFighter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FightersDAO {

    Connection dbConnection = null;

    public void createTableIfNotExists() throws SQLException {
        dbConnection = ConnectionFactory.getConnection();
        String sqlCommand = "CREATE TABLE IF NOT EXISTS mkfighters (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(40) NOT NULL," +
                "category VARCHAR(40) NOT NULL," +
                "weapon VARCHAR(40) NOT NULL)";
        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        stmt.executeUpdate();
        dbConnection.close();
    }

    public List<MKFighter> get() throws SQLException {
        dbConnection = establishConnection();
        List<MKFighter> mkFighters = new ArrayList<>();
        String sqlCommand = "SELECT * FROM mkfighters";

        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int fighterId = rs.getInt("id");
            String fighterName = rs.getString("name");
            String fighterCategory = rs.getString("category");
            String fighterWeapon = rs.getString("weapon");

            MKFighter fighter = new MKFighter(fighterId, fighterName, fighterCategory, fighterWeapon);
            mkFighters.add(fighter);
        }
        dbConnection.close();

        return mkFighters;
    }

    public MKFighter getById(int id) throws SQLException {
        dbConnection = establishConnection();
        MKFighter fighterToReturn = null;
        String sqlCommand = "SELECT * FROM mkfighters WHERE id = ?";
        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            fighterToReturn = new MKFighter(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getString("weapon"));
        }
        dbConnection.close();
        return fighterToReturn;
    }

    public void create(MKFighter mkFighter) throws SQLException {
        dbConnection = ConnectionFactory.getConnection();
        String sqlCommand = "INSERT INTO mkfighters (name, category, weapon) VALUES (?, ?, ?)";

        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        stmt.setString(1, mkFighter.getName());
        stmt.setString(2, mkFighter.getCategory());
        stmt.setString(3, mkFighter.getWeapon());
        System.out.println("Insercoes feitas: " + stmt.executeUpdate());
        dbConnection.close();
    }

    public void delete(int id) throws SQLException {
        dbConnection = establishConnection();
        String sqlCommand = "DELETE FROM mkfighters WHERE ID = ?";

        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        stmt.setInt(1, id);
        System.out.println("Registro deletados: " + stmt.executeUpdate());
        dbConnection.close();
    }

    public void update(int id, MKFighter mkFighter) throws SQLException {
        dbConnection = establishConnection();
        String sqlCommand = "UPDATE mkfighters SET name = ?, category = ?, weapon = ? WHERE id = ?";
        PreparedStatement stmt = dbConnection.prepareStatement(sqlCommand);
        stmt.setString(1,mkFighter.getName());
        stmt.setString(2,mkFighter.getCategory());
        stmt.setString(3,mkFighter.getWeapon());
        stmt.setInt(4, id);
        System.out.println("Registros atualizados: " + stmt.executeUpdate());
        dbConnection.close();
    }

    private Connection establishConnection() {
        Connection con = ConnectionFactory.getConnection();
        return con;
    }
}
