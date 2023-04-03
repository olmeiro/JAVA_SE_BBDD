package database;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public Connection get_connection(){
        Dotenv dotenv = Dotenv.load();

        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://" + dotenv.get("DATABASE_HOST") +
             ":" + dotenv.get("DATABASE_PORT") +
             "/" + dotenv.get("DATABASE_NAME") +
             "", dotenv.get("DATABASE_USER"), dotenv.get("DATABASE_PASSWORD"));
            if(connection != null){
                System.out.println("Conexión éxitosa.");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
