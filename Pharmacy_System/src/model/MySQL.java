package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Thamara
 */
public class MySQL {

    private static Connection connection;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "database_password";
    private static final String DATABASE = "pshop";

    private static Statement createConnection() throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
        }
        return connection.createStatement();
    }

    public static void iud(String query) {
        try {
            createConnection().executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet search(String query) throws Exception {
        return createConnection().executeQuery(query);
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATABASE, USERNAME, PASSWORD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
