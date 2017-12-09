/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.model;

import java.util.Observable;

/**
 *
 * @author virtus
 */
public class Model extends Observable{
    public static enum Flag {
        ADDED, MODIFIED, REMOVED
    }
    
     public void updateAccept(Object arg){
            setChanged();
            notifyObservers(arg);
    }
}
