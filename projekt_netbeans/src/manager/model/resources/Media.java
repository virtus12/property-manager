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
public class Media {
        private final List<MediaModel> mediaModel;
   
        private final String[] mediaColumnsName;
        
        private static final String STM_MEDIA_INSERT = "INSERT into Media values(null,?,?,?,?)";
        private static final String STM_MEDIA_DELETE = "DELETE from Media where Media.id = ?";
        
        private static final String STM_MEDIA_SELECT_ALL  = "SELECT * from Media";
        private static final String STM_MEDIA_SELECT_BY_NID="SELECT * from Media,Properties where Media.nid=?";
        private static final String STM_MEDIA_SELECT_BY_ID="SELECT * from Media where Media.id=?";
        
        private static final String STM_MEDIA_UPDATE_BY_CONTRACTORID = "UPDATE Media set contractor_id = ? where Media.id=?";
        private static final String STM_MEDIA_UPDATE_BY_PERIOD = "UPDATE Media set period = ? where Media.id=?";
        private static final String STM_MEDIA_UPDATE_BY_SERVICEID = "UPDATE Media set service_id = ? where Media.id=?";
        private static final String STM_MEDIA_UPDATE_BY_PRICE = "UPDATE Media set price=? where Media.id=?";
        
        public Media(){
             mediaModel = new ArrayList<>();
             mediaColumnsName = new String[]{"id","contractor_id","period","service_id","price"};
        
        }
        
}
