/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chattingserver;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket; 
import java.net.Socket ; 
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mahmoud
 */
public class ChattingServer {

    /**
     * @param args the command line arguments
     */
    ServerSocket myServer ; 
    
    ChattingServer(){
        try {
            myServer = new ServerSocket(4004);
            while(true){ 
                Socket tempSocket = myServer.accept();
                new ChatHandler(tempSocket); 
            }
        } catch (IOException ex) {
            Logger.getLogger(ChattingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        new ChattingServer();
    }
    
}
    class ChatHandler extends Thread  {
        
        DataInputStream myInputStream ; 
        PrintStream myPrintStream ;
        static Vector<ChatHandler> clientVector = new Vector<ChatHandler>();   
        
        ChatHandler(Socket cs ){
            try {
                myInputStream = new DataInputStream(cs.getInputStream());
                myPrintStream = new PrintStream(cs.getOutputStream());
                ChatHandler.clientVector.add(this) ; 
                start(); 
            } catch (IOException ex) {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void run(){
        
          while(true){
              try { 
                  String commMessage = myInputStream.readLine();
                  sendMessageToAll(commMessage); 
                  
                  
              } catch (IOException ex) {
                  Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        }
        
        void sendMessageToAll(String message){
        
            for(ChatHandler obj : clientVector ){
                obj.myPrintStream.println(message);
            }
        }
    }