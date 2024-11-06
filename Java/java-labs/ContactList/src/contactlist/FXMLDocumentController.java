/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactlist;

import DTO.Contact;
import db.DAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author mahmoud
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField IDfield;
    @FXML
    private TextField FnameFiled;
    @FXML
    private TextField MnameFiled;
    @FXML
    private Button newButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button FirstButton;
    @FXML
    private Button previouseButton;
    @FXML
    private Button LastButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField LnameField;
    @FXML
    private TextField EmailFiled;
    @FXML
    private TextField PhoneFiled;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        
        
    }    

    @FXML
    private void AddingNewContact(ActionEvent event) {
        
        try {
            Contact contact=  new Contact();
            
            contact.setId(Integer.parseInt(IDfield.getText()));
            contact.setFirstName(FnameFiled.getText());
            contact.setMiddleName(MnameFiled.getText());
            contact.setLastName(LnameField.getText());
            contact.setEmail(EmailFiled.getText());
            contact.setPhoneNumber(PhoneFiled.getText());
            DAO.newContact(contact);
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }

    @FXML
    private void UpdateContact(ActionEvent event) {
        
            try {
                System.out.println("in Update Handler  function "); 
                
            Contact contact=  new Contact(Integer.parseInt(IDfield.getText()), FnameFiled.getText(), MnameFiled.getText(),LnameField.getText(), PhoneFiled.getText(), EmailFiled.getText()); 
            DAO.updateContatc( contact );
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }

    @FXML
    private void DeleteContact(ActionEvent event) {
        
        try { 
            
            Contact contact=  new Contact(); 
            contact.setId(Integer.parseInt(IDfield.getText()));
            DAO.deleteContact( contact );
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void FirstContact(ActionEvent event) {
    }

    @FXML
    private void PreviousContact(ActionEvent event) {
    }

    @FXML
    private void LastContact(ActionEvent event) {
    }

    @FXML
    private void NextContact(ActionEvent event) {
        
    }
    
}
