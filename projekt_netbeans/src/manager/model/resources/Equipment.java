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
public class Equipment {
    private final List<EquipmentModel> equipmentModel;
    private final String[] equipmentColumnsName;
     
    private static final String STM_EQUIPMENT_INSERT = "INSERT into Equipment values(null,?,?,?,?)";
    private static final String STM_EQUIPMENT_DELETE = "DELETE from Equipment where Equipment.id = ?";
    
    private static final String STM_EQUIPMENT_SELECT_ALL = "SELECT * from Equipment";
    private static final String STM_EQUIPMENT_SELECT_BY_NID = "SELECT * from Equipment,Properties where Equipment.nid=?";
    private static final String STM_EQUIPMENT_SELECT_BY_ID = "SELECT * from Equipment where Equipment.id=?";
    
    public Equipment(){
         equipmentModel = new ArrayList<>();
         equipmentColumnsName = new String[]{"id","shop","state","guarrante","price"};
    
    }
}
