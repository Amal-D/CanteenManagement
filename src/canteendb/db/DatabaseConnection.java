/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteendb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author project
 */
public class DatabaseConnection {

    private Connection connection = null;

    public DatabaseConnection() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection != null) {
            return connection;
        } else {
            createConnection();
            return connection;
        }
    }

    private void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CanteenDb",
                "root", "root");
    }

}
