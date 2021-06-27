package examplejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private ConnectionFactory connectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {
        Connection dbConnection = null;

        String url = "jdbc:mysql://localhost/digital";
        String user = "root";
        String password = "password";

        try {
            dbConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

}
