package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conexion = db_connect.get_connection()){
            String query = "SELECT * FROM `messages`";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery(); //only retrieve data

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_message"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Author: " + rs.getString("author_message"));
                System.out.println("Date: " + rs.getString("date_message"));
                System.out.println();

            }
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Data don't read it!");
        }
    }

    public static void deleteMessageDB(int id_message) throws SQLException {
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM messages WHERE id_message = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_message);
                int countRowsUpdated = ps.executeUpdate();

                if(countRowsUpdated != 0){
                    System.out.println("Message has been deleted.");
                }else{
                    System.out.println("Message was not found.");
                }

                ps.close();

            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void updateMessageDB(Message message){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;

            try {
               String query = "UPDATE messages SET  message = ? WHERE id_message = ?";
               ps = conexion.prepareStatement(query);
               ps.setString(1, message.getMessage());
               ps.setInt(2, message.getId_message());

                int countRowsUpdated = ps.executeUpdate();

                if(countRowsUpdated != 0){
                    System.out.println("Message has been updated.");
                }else{
                    System.out.println("Message was not updated.");
                }

                ps.close();

            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
