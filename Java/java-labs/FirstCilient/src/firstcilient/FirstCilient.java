/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcilient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahmoud
 */
public class FirstCilient {

    /**
     * @param args the command line arguments
     */
    
    Socket clientSocket ; 
    DataInputStream clientInput ; 
    PrintStream clientOutput ;
    
   public  FirstCilient(){
        try { 
            clientSocket = new Socket("127.0.0.1",4004);
            clientInput = new DataInputStream(clientSocket.getInputStream()); 
            clientOutput = new PrintStream(clientSocket.getOutputStream()); 
            clientOutput.println("hello from client "); 
            clientOutput.println(clientInput.readLine());
            System.out.println(clientInput.readLine()); 
            
        } catch (IOException ex) {
            Logger.getLogger(FirstCilient.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                clientOutput.close();
                clientInput.close();
                clientSocket.close(); 
                
            } catch (IOException ex) {
                Logger.getLogger(FirstCilient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new FirstCilient();
    }
    
}
