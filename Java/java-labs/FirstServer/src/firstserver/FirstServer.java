/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintStream; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */
public class FirstServer {

     /*create server */
    ServerSocket myServer ; 
    Socket tempSocket ; 
    DataInputStream myInput; 
    PrintStream myPrintStream;
    
    public FirstServer (){
    
        try { 
            myServer = new ServerSocket(4004);
            tempSocket = myServer.accept(); 
            myInput= new DataInputStream(tempSocket.getInputStream());
            myPrintStream= new PrintStream(tempSocket.getOutputStream());
            myPrintStream.println(myInput.readLine());
            myPrintStream.println("hello from server");
            System.out.println(myInput.readLine());
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(FirstServer.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                myPrintStream.close();; 
                myInput.close();
                myServer.close(); 
            } catch (IOException ex) {
                Logger.getLogger(FirstServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO codeFirst application logic here
        
        new FirstServer();
    }
    
}
