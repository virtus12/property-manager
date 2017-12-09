/*
 * Aplikacja zaliczeniowa z Inzynieri Oprogramowania
 * Kopiowanie i udostepnianie bez zgody zarzadu Tomaszewska Inc. zabronione  * 
 * Wszelkie prawa zastrzezone dla Tomaszewska Inc.  * 
 */
package manager.model.resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.dbHelper.DBConnect;
import manager.dbHelper.DBExec;
import manager.model.estate.Estate;

/**
 *
 * @author virtus
 */
public class Person {
    private final List<PersonModel> personModel;
    private final String[] personColumnsName;
         
    private static final String STM_PERSON_INSERT = "INSERT into Persons values(null,?,?,?,?,?,?,?)";
    private static final String STM_PERSON_DELETE_BY_ID = "DELETE from Persons where Persons.id = ?";
    private static final String STM_PERSON_DELETE_BY_NID = "DELETE from Persons where Persons.nid = ?"; 
    
    private static final String STM_PERSON_SELECT_ALL = "SELECT * from Persons";
    private static final String STM_PERSON_SELECT_BY_NID = "SELECT * from Persons,Properties where Persons.nid=?";
    private static final String STM_PERSON_SELECT_BY_ID = "SELECT * from Persons where Persons.id=?";
     
    public Person(){
           personModel = new ArrayList<>();
           personColumnsName = new String[]{"id","name","LastName","funkcja","rent","period","nid","salary"};
    }

    public void addPerson(PersonModel pm){
            DBExec dbExec = new DBExec();
            dbExec.prepareQuery(STM_PERSON_INSERT);
            dbExec.setString(1, pm.getName());
            dbExec.setString(2, pm.getLastName());
            dbExec.setString(3, pm.getFunction());
            dbExec.setDouble(4, pm.getRent());
            dbExec.setInt(5, pm.getPeriod());
            dbExec.setInt(6, pm.getNid());
            dbExec.setDouble(7, pm.getSalary());
            dbExec.execQ();
    }
    
    public void removePersonById(int id){
        Connection conn = DBConnect.getInstance().getConnect();
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(STM_PERSON_DELETE_BY_ID);
            stat.setInt(1, id);
            stat.executeUpdate();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);

        }
     }
    
    public void removePersonByNid(int nid){
          Connection conn = DBConnect.getInstance().getConnect();
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(STM_PERSON_DELETE_BY_NID);
            stat.setInt(1, nid);
            stat.executeUpdate();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);

        }
       
    }
    
    public List<PersonModel> getAllPersons(){
        
        return null;
    }
    
    public List<PersonModel> getAllPersonsById(){
        return null;
    
    }
    
    public List<PersonModel> getAllPersonsByNid(){
    
        return null;
    }
    
    public double getMaxRent(){return 0;
}
    
    public boolean isTenanth(int id ){
        return false;
    }
    
    public boolean isWorker(int id){
        return false;
    
    }
    
    public boolean isPeselUnique(String pesel){
        return false;
    }
  
}
