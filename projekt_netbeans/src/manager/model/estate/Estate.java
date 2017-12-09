/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.model.estate;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.dbHelper.DBConnect;
import manager.dbHelper.DBExec;

/**
 *
 * Klasa zarzadzajaca komunikacja miedzykontrolerem a baza danych
 *
 * @author Damian Rakowski
 *
 */
public class Estate {

    private final List<EstateModel> estate;
    private int generatedKey;

    /**
     * zapytanie do bazy danych
     */
    private static final String STM_ESTATE_INSERT = "INSERT into Estate values(null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String STM_ESTATE_DELETE = "DELETE FROM Estate where id=?";
    private static final String STM_ESTATE_SELECT_ALL = "SELECT name, * from Estate ORDER BY id";
    private static final String STM_ESTATE_UPDATE_BY_IMG = "UPDATE Estate set img=? where id=?";
    private static final String STM_ESTATE_UPDATE_BY_NAME = "UPDATE Estate set name=? where id=?";
    private static final String STM_ESTATE_UPDATE_BY_TID = "UPDATE Estate set tid=? where id=?";
    /**
     * komunikaty
     */
    private static final String CREATE_ESTATE_FAILED = "Wystapil problem z utworzeniem nieruchomosci!";
    private static final String CREATE_ESTATE_NO_ID_FAILED = "Wystapil problem z uzyskaniem ID utworzonej nieruchomosci!";
    /**
     * Nazwy kolum
     */
    private final String[] columnsName;

    public Estate() {

        this.columnsName = new String[]{
            "id",
            "img",
            "name",
            "nid",
            "tid",
            "description",
            "country",
            "city",
            "county",
            "province",
            "street",
            "surface",
            "rooms",
            "price"

        };

        estate = new ArrayList<>();
    }

    /**
     *
     * Metoda dodaja do bazy danych nieruchomosc * @param pm
     *
     * @param pm
     */
    public void addEstate(EstateModel pm) {

        DBExec exec = new DBExec(STM_ESTATE_INSERT);
        exec.setString(1, pm.getImg());
        exec.setString(1, pm.getImg());
        exec.setString(2, pm.getName());
        exec.setString(3, pm.getDescription());
        exec.setString(4, pm.getNid());
        exec.setString(5, pm.getTid());
        exec.setString(6, pm.getCountry());
        exec.setString(7, pm.getCity());
        exec.setString(8, pm.getCounty());
        exec.setString(9, pm.getProvince());
        exec.setString(10, pm.getStreet());
        exec.setDouble(11, pm.getSurface());
        exec.setInt(12, pm.getRooms());
        exec.setDouble(13, pm.getPrice());
        exec.execU();
        generatedKey = exec.getGeneratedKey();
        exec.close();
//        Connection conn = DBConnect.getInstance().getConnect();
//        FileInputStream fis = null;
//
//        try {
//
//            PreparedStatement stat = conn.prepareStatement(STM_ESTATE_INSERT);
//
//            stat.setString(1, pm.getImg());
//            stat.setString(2, pm.getName());
//            stat.setString(3, pm.getDescription());
//            stat.setString(4, pm.getNid());
//            stat.setString(5, pm.getTid());
//            stat.setString(6, pm.getCountry());
//            stat.setString(7, pm.getCity());
//            stat.setString(8, pm.getCounty());
//            stat.setString(9, pm.getProvince());
//            stat.setString(10, pm.getStreet());
//            stat.setDouble(11, pm.getSurface());
//            stat.setInt(12, pm.getRooms());
//            stat.setDouble(13, pm.getPrice());
//
//            int affectedRows = stat.executeUpdate();
//
//            if (affectedRows == 0) {
//                throw new SQLException(CREATE_ESTATE_FAILED);
//            }
//
//            try (ResultSet generatedKeys = stat.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    generatedKey = generatedKeys.getInt(1);
//
//                } else {
//                    throw new SQLException(CREATE_ESTATE_NO_ID_FAILED);
//
//                }
//            }
//
//            stat.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
    }

    /**
     *
     * Metoda usuwajaca nieruchomosc z bazy danych
     *
     * @param id
     */
    public void removeEstate(int id) {
        DBExec exec = new DBExec(STM_ESTATE_DELETE);
        exec.setInt(1, id);
        exec.execU();
        exec.close();

//        Connection conn = DBConnect.getInstance().getConnect();
//        PreparedStatement stat;
//        try {
//            stat = conn.prepareStatement(STM_ESTATE_DELETE);
//            stat.setInt(1, id);
//            stat.executeUpdate();
//            stat.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
    }

    public void updateByImg(int id, String path) {
        DBExec exec = new DBExec(STM_ESTATE_UPDATE_BY_IMG);
        exec.setString(1, path);
        exec.setInt(2, id);
        exec.execU();
        exec.close();

//        Connection conn = DBConnect.getInstance().getConnect();
//        PreparedStatement stat;
//        try {
//            stat = conn.prepareStatement(STM_ESTATE_UPDATE_BY_IMG);
//            stat.setString(1, path);
//            stat.setInt(2, id);
//            stat.executeUpdate();
//            stat.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);
//
//        }

    }

    public void updateByName(int id, String name) {
        Connection conn = DBConnect.getInstance().getConnect();
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(STM_ESTATE_UPDATE_BY_NAME);
            stat.setString(1, name);
            stat.setInt(2, id);
            stat.executeUpdate();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void updateByTid(int id, String name) {
        Connection conn = DBConnect.getInstance().getConnect();
        PreparedStatement stat;
        try {
            stat = conn.prepareStatement(STM_ESTATE_UPDATE_BY_TID);
            stat.setString(1, name);
            stat.setInt(2, id);
            stat.executeUpdate();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    /**
     *
     * Metoda pobierajaca z bazy danych wszystkie nieruchomosci
     *
     * @author Damian Rakowski
     * @return List
     *
     */
    public List<EstateModel> getAllEstates() {
        DBExec exec = new DBExec(STM_ESTATE_SELECT_ALL);
        try {
            
            exec.execQ();
            ResultSet set = exec.getResult();
            EstateModel model;
            while (set.next()) {
                model = new EstateModel();
                model.setId(set.getInt(columnsName[0]));
                model.setImg(set.getString(columnsName[1]));
                model.setName(set.getString(columnsName[2]));
                model.setNid(set.getString(columnsName[3]));
                model.setTid(set.getString(columnsName[4]));
                model.setDescription(set.getString(columnsName[5]));
                model.setCountry(set.getString(columnsName[6]));
                model.setCity(set.getString(columnsName[7]));
                model.setCounty(set.getString(columnsName[8]));
                model.setProvince(set.getString(columnsName[9]));
                model.setStreet(set.getString(columnsName[10]));
                model.setSurface(set.getDouble(columnsName[11]));
                model.setRooms(set.getInt(columnsName[12]));
                model.setPrice(set.getDouble(columnsName[13]));
                estate.add(model);
            }
            exec.close();
            return estate;
        } catch (SQLException ex) {
            Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * Metoda zwraca klucz dodanej nieruchomosci
     *
     * @return integer
     *
     */
    public int getGeneratedKey() {
        return generatedKey;

    }

}
