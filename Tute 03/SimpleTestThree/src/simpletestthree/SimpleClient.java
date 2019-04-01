/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestthree;

import com.sun.security.ntlm.Client;

/**
 *
 * @author Charith Jayasanka
 */
public class SimpleClient {

    /**
     * @param args the command line arguments
     */
   
    
    
    public static void main(String[] args) {
         SimpleClient simpleClient=new SimpleClient();
         simpleClient.executeTest();
         
    }
    
    private void executeTest(){
        SimpleTemperatureRecorderServer server=new SimpleTemperatureRecorderServer();
        if(server.isServerConnected()){
            System.out.println("[CLIENT] - The Server is connected. The test can proceed"); 
      server.addTemperature(10);
      server.addTemperature(1);
      server.addTemperature(12);
      server.addTemperature(-0.1);
      server.addTemperature(-18);
      server.addTemperature(18.0); 
        }else{
            System.out.println("[CLIENT] - The server is NOT connected. Terminating Test");
        }
    }
    
}
