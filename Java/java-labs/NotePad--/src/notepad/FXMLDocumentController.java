/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;  
import java.io.File;    
import javafx.scene.media.MediaException;
import javafx.stage.FileChooser;
import java.io.File ; 

/**
 *
 * @author mahmoud
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button playButton;
    @FXML
    private Button pauseButton;
    
      
    private MediaPlayer mediapalyer ; 
    private MediaView mediaView ; 
    
    private String mediaPath;  
    
   
    @FXML
    private Button fileChooseButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      /*  file = new File("/media/mahmoud/Embedded/yocto_fady/ss.mp4"); 
        mediaPath = file.toURI().toString();
        media = new Media(mediaPath); 
        
        mediapalyer= new MediaPlayer(media); 
        
       // mediaview= new MediaView(mediapalyer);
         
        mediaView.setMediaPlayer(mediapalyer);
        mediapalyer.setAutoPlay(true); */
       
        
        
    } 
    @FXML
    private void playVideoAction(ActionEvent event) {
    }

    @FXML
    private void PauseVideoAction(ActionEvent event) {
    }

    @FXML
    private void FileChoorAction(ActionEvent event) {
        System.setProperty("javafx.platform", "Windows");
        
        
        FileChooser filechooser = new FileChooser() ; 
        File file =filechooser.showOpenDialog(null); 
        mediaPath = file.toURI().toString(); 
        
        if( mediaPath != null ){
           System.out.println("in media palyer ");
            System.out.println("Media file path: " + mediaPath);
            try{
            Media media = new Media(mediaPath) ; 
            mediapalyer = new MediaPlayer(media ); 
            mediaView.setMediaPlayer(mediapalyer); 
            mediapalyer.play(); 
            }catch(MediaException e ){
                 System.out.println("Failed to create MediaPlayer: " + e.getMessage());
            }
        }
        
    }
    
    
}
