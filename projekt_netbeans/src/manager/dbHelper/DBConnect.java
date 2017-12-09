/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtus
 */
public class DBConnect {
    private final String driver = "org.sqlite.JDBC";
    private final String url = "jdbc:sqlite:manager.db";
  
    
    private DBConnect(){
        try {
            Class.forName(driver);
        
        }
        catch(Exception ee){
            ee.printStackTrace();
        
        }   
    }
    public static DBConnect getInstance()
    {
        return new DBConnect();
    }
    
    public Connection getConnect(){
        try {
            return  DriverManager.getConnection(url);
        } catch (SQLException ex) {
//            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
}
}