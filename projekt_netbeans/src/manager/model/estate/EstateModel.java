/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.model.estate;

import manager.model.Model;

/**
 * 
 * Klasa reprezentujaca pojedynczy model nieruchomosci
 * 
 * @author Damian Rakowski
 */
public class EstateModel extends Model{
    private int id;
 
    private String img;
    
    private String name;
    
    private String description;
    
    private String nid;
    
    private String tid;
    
    private String country;
    
    private String city;
    
     private String county;
     
    private String province;
    
    private String street;
    
    private double surface;
    
    private int rooms;
    
    private double price;
    
    public EstateModel(){}
    
    public EstateModel(String name, String description, String nid, String tid, String country, String city, String county, String province, String street, int surface, int rooms, float price) {
        this.name = name;
        
        this.description = description;
        
        this.nid = nid;
        
        this.tid = tid;
        
        this.country = country;
        
        this.city = city;
        
        this.county = county;
        
        this.province = province;
        
        this.street = street;
        
        this.surface = surface;
        
        this.rooms = rooms;
        
        this.price = price;
    }
  

    public int getId() {
        
        return id;
    }

    public void setId(int id) {
          
        this.id = id;
          
    }

  
    public String getImg(){
    
        return img;
    }
    
    public void setImg(String img) {
             this.img = img;
    }

    public String getName() {
        
        return name;
    }

    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getDescription() {
        
        return description;
        
    }

    public void setDescription(String description) {
        
        this.description = description;
    }

    public String getNid() {
        
        return nid;
    }

    public void setNid(String nid) {
        
        this.nid = nid;
    }

    public String getTid() {
        
        return tid;
    }

    public void setTid(String tid) {
        
        this.tid = tid;
    }

    public String getCountry() {
        
        return country;
    }

    public void setCountry(String country) {
        
        this.country = country;
    }

    public String getCity() {
        
        return city;
    }

    public void setCity(String city) {
        
        this.city = city;
    }

    public String getCounty() {
        
        return county;
    }

    public void setCounty(String county) {
        
        this.county = county;
    }

    public String getProvince() {
        
        return province;
    }

    public void setProvince(String province) {
        
        this.province = province;
    }

    public String getStreet() {
        
        return street;
    }

    public void setStreet(String street) {
        
        this.street = street;
    }

    public double getSurface() {
        
        return surface;
    }

    public void setSurface(double surface) {
        
        this.surface = surface;
    }

    public int getRooms() {
        
        return rooms;
    }

    public void setRooms(int rooms) {
        
        this.rooms = rooms;
    }

    public double getPrice() {
        
        return price;
    }

    public void setPrice(double price) {
        
        this.price = price;
    }
    
   
    
}
