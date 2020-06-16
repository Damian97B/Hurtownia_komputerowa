/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Damian
 */
public class DBConnector {
    
    public static Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/hurtowniakomputerowa", "postgres", "root");
    return connection;
    }
    
}
