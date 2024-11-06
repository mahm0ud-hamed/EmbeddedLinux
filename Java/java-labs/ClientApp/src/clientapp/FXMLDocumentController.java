/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.DataInputStream; 
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author mahmoud
 */
public class FXMLDocumentController implements Initializable {
    
    Socket tempSocket ; 
    DataInputStream myInput ; 
    PrintStream myPrint;
    
    
    private Label label;
    @FXML
    private TextField TextOut;
    @FXML
    private Button btnSend;
    @FXML
    private TextArea textIn;
/*    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
  */  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            tempSocket = new Socket("127.0.0.1", 4004) ;
            myInput = new DataInputStream(tempSocket.getInputStream()); 
            myPrint = new PrintStream(tempSocket.getOutputStream()); 
           
            new Thread(){
               public void  run(){
                while(true)  {
                   try {
                      
                        String message = myInput.readLine();  
                    
                        textIn.appendText(message+"\n");
                       
                       
                       
                   } catch (IOException ex) {
                       Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
               }
            
            }.start();


        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void SendAction(ActionEvent event) {
        System.out.println("in button action handler"); 
        myPrint.println(TextOut.getText());
        TextOut.clear(); 
        
    }
    
}
