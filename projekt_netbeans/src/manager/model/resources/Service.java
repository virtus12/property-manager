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
public class Service {
    private final List<ServiceModel> serviceModel;
    private final String[] serviceColumnsName;
    
    public Service(){
       serviceModel = new ArrayList<>();
       serviceColumnsName = new String[]{"id","name"};
    
    }
}
