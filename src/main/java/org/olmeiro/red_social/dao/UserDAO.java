package org.olmeiro.red_social.dao;

import database.DbConnection;
import org.olmeiro.red_social.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    static String cantCreateUser = "\n user could not be created \n";
    static String createdUser = "\n user created, you can now log in \n";
    static String cantListUsers = "\n could not list users \n";
    static String updatedUser = "\n user updated \n";
    static String cantUpdateUser = "\n user could not be updated \n";
    static String loginFailed = "login failed";
    static String dbAuthFailed = "\n could not authenticate with the server \n";

    public static void createUserOnDB(User user) {
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "INSET INTO users (email, pw, full_name) values (?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFullName());
                ps.executeUpdate();
                ps.close();
                System.out.println(createdUser);
            } catch (SQLException e) {
                System.out.println(cantCreateUser);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void listUsersDB(){
        DbConnection dbConnection = new DbConnection();
        try(Connection conexion = dbConnection.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT * from users";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();

                while(rs.next()){
                    System.out.println("\n[ID: " + rs.getString("id_user") + " | ");
                    System.out.print("Correo: -"+rs.getString("correo")+" | ");
                    System.out.print("Nombre: "+rs.getString("nombre_completo")+" ] ");
                }
            }catch(SQLException ex){
                System.out.println(cantListUsers);
            }
        }catch (SQLException ex){
            System.out.println(ex);
        }
    }

    public static void editUserOnDB(User user){
        DbConnection dbConnection = new DbConnection();
        try (Connection conexion = dbConnection.get_connection()) {
            PreparedStatement ps=null;
            try {
                String query="update usuarios set correo = ?, clave = ?, nombre_completo = ? where id_usuario = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFullName());
                ps.setInt(4, user.getUserId());
                ps.executeUpdate();
                System.out.println(updatedUser);
            } catch (SQLException e) {
                System.out.println(cantUpdateUser);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static User loginDb(User user) {
        DbConnection dbConnection = new DbConnection();
        try (Connection conexion = dbConnection.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * from users WHERE email=? and pw=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                rs = ps.executeQuery(query);
                User login = new User();

                if (rs.next()) {
                    System.out.println("Login correct!");
                    login.setUserId(rs.getInt("id_user"));
                    login.setEmail(rs.getString("email"));
                    login.setFullName(rs.getString("full_name"));
                } else {
                    System.out.println(loginFailed);
                }
                //retrive empty or object with user:
                return login;
            } catch (SQLException e) {
                System.out.println(loginFailed);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //if no login is successful we return an empty object
        return null;
    }
}
