/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexercisetwoclient;

/**
 *
 * @author 2017135
 */
public class CodingExerciseTwoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CodingExerciseTwoClient client=new CodingExerciseTwoClient();
        
    }
    
    private void executeTest(){
        System.out.println("[CLIENT] - Test is Starting...");
        
        System.out.println( isConnected("Cname"));
        System.out.println("[CLIENT] - Test completed.");
    }

    private static String isConnected(java.lang.String arg0) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.isConnected(arg0);
    }



    
    
    
}
