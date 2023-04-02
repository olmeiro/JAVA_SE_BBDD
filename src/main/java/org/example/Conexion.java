package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Instance:
    private static Conexion instance;

    /**
     *  Function to ge the instance of the class, if not, create a new one (Singleton pattern).
     */
    public static Conexion getInstance() {
        if(instance == null) instance = new Conexion();
        return instance;
    }

    /**
    *   Function to generate the config connection to MySQL.
     * @return MySQL connection.
    */
    public Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages_app","root","");

        return connection;
    }
}
