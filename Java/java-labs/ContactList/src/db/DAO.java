/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import DTO.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author mahmoud
 */
public class DAO {
    
    public static int newContact(Contact contact)throws SQLException{
      int insertionStatus = 0 ; 
    
      DriverManager.registerDriver(new ClientDriver());
      
      Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root"); 
      PreparedStatement statment=  con.prepareStatement("INSERT INTO contactinfo values (?, ?, ?, ?,?,?)"); 
      statment.setInt(1,contact.getId()); 
      statment.setString(2,contact.getFirstName());
      statment.setString(3,contact.getMiddleName()); 
      statment.setString(4, contact.getLastName());
      statment.setString(5, contact.getPhoneNumber());
      statment.setString(6,contact.getEmail());
     insertionStatus=  statment.executeUpdate();
     
      con.close(); 
       return  insertionStatus ;
    
    }

    
    public static int updateContatc(Contact contact )throws SQLException{
            int updateStatus = 0 ;
           
         System.out.println("Update function "); 
            DriverManager.registerDriver(new ClientDriver());
            Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
            PreparedStatement statment=  con.prepareStatement("UPDATE contactinfo set FNAME = ? , MNAME= ? , LNAME = ? , PHONE= ? , EMAIL = ? where id = ? ");
            statment.setString(1,contact.getFirstName());
            statment.setString(2,contact.getMiddleName()); 
            statment.setString(3, contact.getLastName());
            statment.setString(4, contact.getPhoneNumber());
            statment.setString(5,contact.getEmail());
            statment.setInt(6,contact.getId());                
            updateStatus=  statment.executeUpdate();
            con.close(); 
        
            return updateStatus;
    }
    
    public static int deleteContact(Contact contact)throws SQLException{    
        int updateStatus = 0 ;
        DriverManager.registerDriver(new ClientDriver());
        Connection con =  DriverManager.getConnection("jdbc:derby://localhost:1527/ContactsList","root","root");
        PreparedStatement statment=  con.prepareStatement("DELETE FROM contactinfo  where id= ? ");
        statment.setInt(1,contact.getId());    
        updateStatus=  statment.executeUpdate();
        con.close(); 
        return updateStatus ; 
    
    }
 
}
