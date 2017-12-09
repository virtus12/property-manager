/*
 * Aplikacja zaliczeniowa z Inzynieri Oprogramowania
 * Kopiowanie i udostepnianie bez zgody zarzadu Tomaszewska Inc. zabronione  * 
 * Wszelkie prawa zastrzezone dla Tomaszewska Inc.  * 
 */
package manager.dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author virtus
 */
public class DBExec {
    
    private int generatedKey;
    private PreparedStatement stat;
    private Connection conn;
    
    public DBExec(){
        conn = DBConnect.getInstance().getConnect();
    }
    
    public DBExec(String q){
        conn = DBConnect.getInstance().getConnect();
        prepareQuery(q);
    
    }
    
    public void prepareQuery(String query){
   
        try {
            stat = conn.prepareStatement(query);
            } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    public void execQuery(String query){
          try {
            stat = conn.prepareStatement(query);
            } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void setString(int ind, String value){
        try {
            stat.setString(ind, value);
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setInt(int ind, int value){
        try {
            stat.setInt(ind, value);
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public void setDouble(int ind, double value){
           try {
            stat.setDouble(ind, value);
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void execU(){
          int affectedRows = 0;
        try {
            affectedRows = stat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }

            if (affectedRows == 0) {
//                throw new SQLException(CREATE_ESTATE_FAILED);
            }

            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedKey = generatedKeys.getInt(1);

                } else {
//                    throw new SQLException(CREATE_ESTATE_NO_ID_FAILED);

                }
            } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void execQ(){
        try {
            stat.execute();
          
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    public void close(){
        try {
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getResult(){

  
                    try {
            ResultSet set = stat.getResultSet();
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(DBExec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
    
    public int getGeneratedKey(){
        return generatedKey;
    
    }
    

}
