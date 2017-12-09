/*
 * Aplikacja zaliczeniowa z Inzynieri Oprogramowania
 * Kopiowanie i udostepnianie bez zgody zarzadu Tomaszewska Inc. zabronione  * 
 * Wszelkie prawa zastrzezone dla Tomaszewska Inc.  * 
 */
package manager.model.resources;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author virtus
 */
public class Renovation {
     
        private final List<RenovationModel> renovationModel;
        private final String[] renovationColumnsName;
        
        private static final String STM_RENOVATION_INSERT = "INSERT into Renovations values(null,?,?,?,?,?)";
        private static final String STM_RENOVATION_DELETE = "DELETE from Renovation where Renovation.id = ?";
        
        private static final String STM_RENOVATION_SELECT_ALL = "SELECT * from Renovation";
        private static final String STM_RENOVATION_SELECT_BY_NID = "SELECT * from Renovation,Properties where Renovation.nid=?";
        private static final String STM_RENOVATION_SELECT_BY_ID = "SELECT * from Renovation where Renovation.id=?";

        public Renovation(){
             renovationModel = new ArrayList<>();
             renovationColumnsName = new String[]{"id","contractor_id","state","data_start","data_stop"};
        
        }
       
}
