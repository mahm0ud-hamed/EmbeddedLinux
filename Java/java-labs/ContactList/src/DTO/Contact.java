/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mahmoud
 */
public class Contact {
    private int id ; 
    private String firstName ; 
    private String middleName ; 
    private  String LastName ;  
    private String phoneNumber ; 
    private String Email ; 
    
    public  Contact( ){}

    public Contact(int id, String firstName, String middleName, String LastName, String phoneNumber, String Email) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.LastName = LastName;
        this.phoneNumber = phoneNumber;
        this.Email = Email;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    
    
}
