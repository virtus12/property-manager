/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.controller;

import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import manager.model.estate.Estate;
import manager.model.estate.EstateModel;
import manager.view.estate.EstateDialog;
import manager.view.estate.panel.FillterPanel;
import manager.view.estate.panel.LocalPanel;
import manager.view.estate.panel.TablePanel;

/**
 * Klasa odpowiedzialna za komunikacje miedzy baza danych, modelem i widokiem
 *
 * @author Damian Rakowski
 * @version 1.0
 *
 * 14.04.2017 created
 *
 */
public class EstateController implements Runnable{

    private EstateDialog estateDialog;
    private final FillterPanel fillterPanel;
    private final TablePanel tablePanel;
    private final LocalPanel localPanel;
    private final EstateModel model;
        
    private final Estate command;
    private StringBuilder errors;
    private int generatedKey;
    private final Set<String> countries;
    private final Set<String> cities;
    private final Set<String> provinces;
    private final Set<String> streets;
    private final Set<String> counties;

    public EstateController() {
      
        
        model = new EstateModel();
        command = new Estate();
        countries = new TreeSet<>();
        cities = new TreeSet<>();
        provinces = new TreeSet<>();
        streets = new TreeSet<>();
        counties = new TreeSet<>();
        
        tablePanel = new TablePanel(this);
        fillterPanel = new FillterPanel(this);
        localPanel = new LocalPanel(this);
        
     
        this.model.addObserver(tablePanel);
        this.model.addObserver(fillterPanel);
        this.model.addObserver(localPanel);

    }
    
    /**
    * Tworzy obiekt okienka dialogowego z nieruchomosciami 
    * oraz uwidacznia je.
    */


     @Override
    public void run() {
        estateDialog = new EstateDialog(this, ((BasicController)AppRunner.baseFrame).getFrameInstance(), false);
        model.addObserver(estateDialog);
        estateDialog.setVisible(true);
    }
    /**
    *
    * Zwraca instancie gornego panelu z filtrami
    *
    * @return FillterPanel
    */
    public FillterPanel getFillterPanel() {
        return fillterPanel;

    }

    /**
    *
    * Zwraca instancie gornego panelu z filtrami lokalizacji
    *
    * @return FillterPanel
    */
    public LocalPanel getLocalPanel() {
        return localPanel;

    }
    
    /**
    *
    * Zwraca instancie tabeli z nieruchomosciami
    *
    * @return TablePanel
    */
    public TablePanel getTablePanel() {
        return tablePanel;

    }
    /**
    *
    * Zwraca instancje modelu
    *
    * @return model
    */
    public EstateModel getModel(){
        return model;    
    }

      /**
    *
    * Zwraca instancje okna dialogowego
    *
    * @return EstateDailog
    */
    public EstateDialog getDialog(){
        return estateDialog;    
    }
    
    /**
    * Dodaje nieruchomosc do bazy danych
    */    
    public void addEstate() {
        if (validation()) {
            command.addEstate(model);
            generatedKey = command.getGeneratedKey();
            model.updateAccept(EstateModel.Flag.ADDED);
        } else {
            JOptionPane.showMessageDialog(estateDialog.getDialogInstance(), errors.toString(), "Blad przesylanych danych", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
    * 
    * Usuwa nieruchomosc z bazy danych
    *
    * @param id
    */
    public void removeEstate(int id) {
        command.removeEstate(id);
        model.updateAccept(EstateModel.Flag.REMOVED);
    }
    
    /**
    *
    * Pobiera wszystkie kraje z bazy danych
    * 
    * @return Set
    */
    public Set<String> getAllCountries() {
        for (EstateModel c : command.getAllEstates()) {
            if (!c.getCountry().equals("")) {
                countries.add(c.getCountry());
            }

        }
        return countries;
    }
    
    /**
    *
    * Pobiera wszystkie miasta z bazy danych
    * 
    * @return Set
    */
    public Set<String> getAllCities() {
        for (EstateModel c : command.getAllEstates()) {
            if (!c.getCity().equals("")) {
                countries.add(c.getCity());
            }
        }
        return cities;
    }
    
    /**
    *
    * Pobiera wszystkie ulice z bazy danych
    * 
    * @return Set
    */
    public Set<String> getAllStreets() {
        for (EstateModel c : command.getAllEstates()) {
            if (!c.getStreet().equals("")) {
                streets.add(c.getStreet());
            }
        }
        return streets;
    }
   
    /**
    * Pobiera wszystkie wojewodztwa z bazy danych
    * 
    * @return Set
    */
    public Set<String> getAllProvinces() {
        for (EstateModel c : command.getAllEstates()) {
            if (!c.getProvince().equals("")) {
                provinces.add(c.getProvince());
            }
        }
        return provinces;
    }
  
    /**
    *
    * Pobiera wszystkie powiaty z bazy danych
    * 
    * @return Set
    */
    public Set<String> getAllCounties() {
        for (EstateModel c : command.getAllEstates()) {
            if (!c.getCounty().equals("")) {
                counties.add(c.getCounty());
            }
        }
        return counties;
    }
   
    /**
    *
    * Waliduje przeslane dane
    * 
    * @return boolean
    */
    private boolean validation() {
        errors = new StringBuilder();

        if (model.getName().equals("")) {
            errors.append("Nazwa jest wymagana!\n");
        }

        if (model.getCountry().equals("")) {
            errors.append("Kraj jest wymagany!\n");
        }

        if (errors.length() == 0) {
            return true;
        }

        return false;

    }

    public void updateByImg(int id, String path){
        command.updateByImg(id, path);
    }
    
    public void updateByName(int id, String name){
         command.updateByName(id, name);
    }
    
    public void updateByTid(int id, String name){
        command.updateByTid(id, name);
    
    }
    
    public int getGeneratedKey() {
        return generatedKey;
    }

   
}
