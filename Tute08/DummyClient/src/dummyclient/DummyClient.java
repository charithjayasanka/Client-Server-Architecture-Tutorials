/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummyclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import server.Exception_Exception;
import server.Point2D;

/**
 *
 * @author Student
 */
public class DummyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DummyClient dummyClient = new DummyClient();
        dummyClient.executeTest();

    }

    private void executeTest() {
        System.out.println("[CLIENT] - Starting Test...");

        if (testConnection().equalsIgnoreCase("OK")) {
            System.out.println("[CLIENT] - The test to the server succeeded");
            double a = 3.0;
            double b = 5.0;
            System.out.println("[CLIENT] - Asking the server to  find the MinimumBetween(3, 5).");

            double ans = findMinimumBetween(a, b);
            System.out.println("[CLIENT] - Server has replied that the answer for minimum between 3 and 5 is " + ans);
            double correctans = (a < b ? a : b);
            System.out.println("[CLIENT] - The correct answer is " + correctans);
            System.out.println("[CLIENT] - The answer returned from the server is : " + (ans == correctans ? " Correct " : " Wrong "));

            System.out.println("[CLIENT] - Asking the server to addSample 1.0 , 3.4 , 5.0, 7.12");

            String confirm1 = addSample(1.0);
            String confirm2 = addSample(3.4);
            String confirm3 = addSample(5.0);
            String confirm4 = addSample(7.12);

            if (confirm1.equalsIgnoreCase("Done") && confirm2.equalsIgnoreCase("Done") && confirm3.equalsIgnoreCase("Done") && confirm4.equalsIgnoreCase("Done")) {
                System.out.println("[CLIENT] - The methods has been executed successfully");
            }
            else{
                System.out.println("The test has failed");
            }
            
            System.out.println("[CLIENT] - Invoking findMinimumBetweenWithException to test");
            try {
                double x= findMinimumBetweenWithException(null, null);
            } catch (Exception_Exception ex) {
                System.out.println("[CLIENT] - Method tested and works successfully");
            //    Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("[CLIENT] - Defining an instance of Point2D with coordinates 5.4 and 4.5");
            Point2D point2D=new Point2D();
            
            point2D.setX(5.4);
            point2D.setY(4.5);
            System.out.println("[CLIENT] -  Invoking the web method findMinimumCoordinate");
            double minCord=findMinimumCoordinate(point2D);
            
            System.out.println("[CLIENT] - The server has replied that the answer is "+minCord);
            
            System.out.println("[CLIENT] - The answer returned from the server is "+(minCord==4.5?"Correct" : "Wrong"));
            
        } else {
            System.out.println("[CLIENT] - The test failed");
        }
    }

    private static String testConnection() {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.testConnection();
    }

    private static Double findMinimumBetween(java.lang.Double a, java.lang.Double b) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.findMinimumBetween(a, b);
    }

    private static String addSample(java.lang.Double sample) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.addSample(sample);
    }

    private static Double findMinimumBetweenWithException(java.lang.Double a, java.lang.Double parameter1) throws Exception_Exception {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.findMinimumBetweenWithException(a, parameter1);
    }

    private static Double findMinimumCoordinate(server.Point2D point) {
        server.TestWebService_Service service = new server.TestWebService_Service();
        server.TestWebService port = service.getTestWebServicePort();
        return port.findMinimumCoordinate(point);
    }

}
