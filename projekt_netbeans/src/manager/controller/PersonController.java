/*
 * Aplikacja zaliczeniowa z Inzynieri Oprogramowania
 * Kopiowanie i udostepnianie bez zgody zarzadu Tomaszewska Inc. zabronione  * 
 * Wszelkie prawa zastrzezone dla Tomaszewska Inc.  * 
 */
package manager.controller;

import javax.swing.JOptionPane;
import manager.model.resources.Person;
import manager.model.resources.PersonModel;
import manager.view.estate.panel.PersonPanel;

public class PersonController {
    private final PersonPanel personPanel;
    private final Person personCommand;
    private final PersonModel personModel;
    private StringBuilder errors;
    
    public PersonController(){
            personPanel = new PersonPanel(this);
            personCommand = new Person();
            personModel = new PersonModel();
   
    }
    
    public PersonPanel getPersonPanel(){
        return personPanel;
     }
    
    public PersonModel getPersonModel(){
        return personModel;
    
    }
    private boolean validator(){
           errors = new StringBuilder(); 
           if(personModel.getName().equals("")){
               errors.append("Pole imie nie moze byc puste!\n");
           }
           
           if(personModel.getLastName().equals("")){
               errors.append("Pole nazwisko nie moze byc puste!\n");
           }
           
           if(personModel.getPesel().equals("")){
               errors.append("Pole pesel nie moze byc puste!\n");
           }
           
           if(errors.length() == 0)
              return true;
           return false;
    }    
    
    public void addPerson(PersonModel pm){
       if(validator()){
        personCommand.addPerson(pm);
        JOptionPane.showMessageDialog(personPanel, "Dodano nowego"+" "+personModel.getFunction()+"a:"+personModel.getName()+" "+personModel.getLastName(), "Komunikat", JOptionPane.INFORMATION_MESSAGE);
        }else {
           JOptionPane.showMessageDialog(personPanel, errors.toString(), "Blad dodawanej zawrtosci", JOptionPane.ERROR_MESSAGE);

        }
        }
    

}
