/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Govind Kumar
 */
public class DbConnection {

    private DbConnection() {

    }

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {

        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/management_system33", "root", "123456");
                System.out.println("Connection created successfully...");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;

    }
    
   
}

