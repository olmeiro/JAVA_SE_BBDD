package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    public static  void createMessageDB (Message message) {
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()){
            //insert data
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO messages (`message`, `author_message`) VALUES (?, ?)";

                ps = conexion.prepareStatement(query);

                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthor_menssage());
                ps.executeUpdate();
                ps.close();

                System.out.println("Message created.");
            }catch (SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void  readMessageDB(){

    }

    public static void deleteMessageDB(int id_mensaje){

    }

    public static void updateMessageDB(Message mensaje){

    }
}
