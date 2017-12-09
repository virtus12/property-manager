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
public class Contractor {
     
      private final List<ContractorModel> contractorModel;
      
      private final String[] contractorColumnsName;
      
      public Contractor(){
           contractorModel = new ArrayList<>();
           contractorColumnsName = new String[]{"id","name"};
      
      }
}
