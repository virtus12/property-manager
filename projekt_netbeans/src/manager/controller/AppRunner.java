/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import manager.dbHelper.DBExec;

/**
 *
 * @author virtus
 */
public class AppRunner {

    public static final String IMG_CAT = "./images/img/";
    public static final String IMG_TMP_CAT = "./images/tmp/";
    public static final String NO_IMG_FILE_NAME = "no-image";
    public static final String NO_IMG_FILE_EXT = "png";

    public static Runnable baseFrame;
    public static Runnable estateController;
    
    @SuppressWarnings("empty-statement")
    public static void main(String[] arg) {
        try {

            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppRunner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        baseFrame = new BasicController();
        Thread thread = new Thread(baseFrame);
        thread.start();
    }
    
    public static void createEstateDialog() {
        estateController = new EstateController();
        Thread thread = new Thread(estateController);
        thread.start();
    }

}
