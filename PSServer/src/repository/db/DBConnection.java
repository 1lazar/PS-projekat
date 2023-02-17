/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Laza Laki Lakosta
 */
public class DBConnection {
    private static DBConnection instance;
    private Connection conn;

    private DBConnection() throws SQLException {
        System.out.println("Kreiraj konkenciju....");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekatoptika", "root", "");
        conn.setAutoCommit(false);
    }
    
    public Connection getConnection() throws Exception {
        if (conn == null || conn.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        }
        return conn;
    }
    
    public static DBConnection getInstance() throws SQLException{
        if(instance == null){
            System.out.println("Kreiraj konkenciju jer ne postoji...");
            instance = new DBConnection();
        }
        return instance;
    }
}
