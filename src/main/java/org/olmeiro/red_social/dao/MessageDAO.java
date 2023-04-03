package org.olmeiro.red_social.dao;

import database.DbConnection;
import org.olmeiro.red_social.model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {

    static String cantCreateMessage = "\n no se pudo crear el mensaje \n";
    static String createdMessage = "\n mensaje creado \n";
    static String cantListMessages = "\n no se pudo listar los mensajes \n";
    static String deletedMessage = "\n mensaje eliminado \n";
    static String cantDeleteMessages = "\n no se pudo eliminar el mensaje \n";

    public static  void createMessageDB (Message message) {
        DbConnection dbConnection = new DbConnection();

        try(Connection conexion = dbConnection.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO messages (id_user, message,date) VALUES (?, ?, CURRENT_TIMESTAMP)";

                ps = conexion.prepareStatement(query);
                ps.setInt(1, message.getUserId());
                ps.setString(2, message.getMessage());
                ps.executeUpdate();
                System.out.println(createdMessage);
                ps.close();
            }catch (SQLException e){
                System.out.println(cantCreateMessage);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public static void listMessageDB(){
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "select m.id_message,m.message,m.date,u.full_name from messages m join users u on m.id_user=u.id_user";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery(); //only retrieve data

                while (rs.next()) {
                    while (rs.next()) {
                        System.out.print("\n[ID: " + rs.getInt("id_message") + " | ");
                        System.out.print("Message: -" + rs.getString("message") + " | ");
                        System.out.print("Date: -" + rs.getString("date") + " | ");
                        System.out.print("Author: " + rs.getString("full_name") + " ] ");
                    }
                }
            }catch (SQLException e){
                System.out.println(cantListMessages);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public static void deleteMessageDB(Message message) throws SQLException {
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM messages WHERE id_message = ? and id_user = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, message.getMessageId());
                ps.setInt(2, message.getUserId());
                ps.executeUpdate();
                ps.close();
                System.out.println(deletedMessage);

            }catch (SQLException e){
                System.out.println(cantDeleteMessages);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void updateMessageDB(Message message){
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()) {
            PreparedStatement ps = null;
            try {
               String query = "UPDATE messages SET  message = ? WHERE id_message = ? and id_user = ?";
               ps = conexion.prepareStatement(query);
               ps.setString(1, message.getMessage());
               ps.setInt(2, message.getMessageId());
               ps.setInt(3, message.getUserId());
               ps.executeUpdate();
               ps.close();

            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
