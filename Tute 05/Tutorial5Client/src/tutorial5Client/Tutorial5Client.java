/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial5Client;

/**
 *
 * @author 2017135
 */
public class Tutorial5Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tutorial5Client client=new Tutorial5Client();
        client.executeTest();
    }
    private void executeTest(){
        System.out.println("[CLIENT] - Executing Connection Test");
        if(isConnected()){
            System.out.println("[CLIENT] - Server is connected, test can continue...");
            System.out.println(hello("Charith"));
           
    }
        else{
            System.out.println("[CLIENT] - Server is NOT Connected, test has failed ");
        }
    }
    private static Boolean isConnected(){
        tutorial5Client.SimpleWebService_Service service=new tutorial5Client.SimpleWebService_Service();
        tutorial5Client.SimpleWebService port=service.getSimpleWebServicePort();
        return port.isConnected();
    }

    private static String hello(java.lang.String name) {
        tutorial5Client.SimpleWebService_Service service = new tutorial5Client.SimpleWebService_Service();
        tutorial5Client.SimpleWebService port = service.getSimpleWebServicePort();
        return port.hello(name);
    }
    
}
