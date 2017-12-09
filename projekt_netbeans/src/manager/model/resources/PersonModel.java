 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.model.resources;

/**
 *
 * @author virtus
 */
public class PersonModel {

    public PersonModel(String name, String LastName, String pesel, String function, double rent, int id, int period, int nid) {
        this.name = name;
        this.LastName = LastName;
        this.pesel = pesel;
        this.function = function;
        this.rent = rent;
        this.nid = id;
        this.period = period;
    }

    public PersonModel(){
        this.name = null;
        this.LastName = null;
        this.pesel = null;
        this.function = null;
        this.rent = 0.0;
        this.nid = 0;
        this.period = 0;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }
    
     public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    
    }
    
    public double getSalary(){
       return this.salary;
    
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    
    }
    
    public String getDesc(){
        return this.desc;
    
    }
    
    public void setPeriod(int period){
        this.period = period;
    }
    
    public int getPeriod(){
        return period;
    
    }
    
    String name;
    
    String LastName;
    
    String pesel;
    
    String function;
    
    String desc;
       
    double salary;
    
    double rent;
          
    int period;
    
    int nid;
    
    
}

