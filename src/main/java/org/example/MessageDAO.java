package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {


    /**
     * Function to get database connection.
     * @return connection MySQL connection.
     */
public static Connection getConnection() throws SQLException {
    Conexion dbConnection = Conexion.getInstance();
    return dbConnection.getConnection();
}

public static  void createMessageDB (Message message) throws SQLException {
        //Get connection:
        Connection connection = getConnection();

        //prepare query:
        PreparedStatement ps = null;

        String query = "INSERT INTO messages (`message`, `author_message`) VALUES (?, ?)";

        //Set params.
        ps = connection.prepareStatement(query);
        ps.setString(1, message.getMessage());
        ps.setString(2, message.getAuthor_menssage());
        ps.executeUpdate();
        ps.close();

        System.out.println("Message created.");
    }

    public static void  readMessageDB(){

    }

    public static void deleteMessageDB(int id_mensaje){

    }

    public static void updateMessageDB(Message mensaje){

    }
}
