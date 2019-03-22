/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexerciseoneclient;

/**
 *
 * @author 2017135
 */
public class CodingExerciseOneClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CodingExerciseOneClient client = new CodingExerciseOneClient();
        client.executeTest();
    }

    private void executeTest() {
        System.out.println("[CLIENT] - Test Starting...");

        if (testConnection("Charith")) {
            System.out.println("[CLIENT] - Server has returned: " + sendMessage("Hello !"));
        } else {
            System.out.println("[CLIENT] - Server is not reachable");
        }
        System.out.println("[CLIENT] - Test Completed.");
    }

  

    private static String sendMessage(java.lang.String message) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.sendMessage(message);
    }

    private static Boolean testConnection(java.lang.String arg0) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.testConnection(arg0);
    }

}
