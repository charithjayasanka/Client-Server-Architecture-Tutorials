/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charith Jayasanka
 */
public class SimpleClient {

    SimpleCalculatorServer server = new SimpleCalculatorServer();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleClient simpleClient = new SimpleClient();

        try {
            simpleClient.executeTest();
        } catch (SimpleCalculatorServerException ex) {
            Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void executeTest() throws SimpleCalculatorServerException {
        System.out.println("[CLIENT] - Testing if the server is connected...");
        if (server.isServerConnected()) {
            System.out.println("[CLIENT] - The Client is connected, the test can proceed...");
            int a = 2;
            int b = 5;
            System.out.println("[CLIENT] - Asking the server what is the sum of " + a + " and " + b + "...");
            int sum = server.addIntegerNumbers(a, b);
            System.out.println("[CLIENT] - The server has replied that the sum of " + a + " and " + b + " is " + sum);
            if (sum == a + b) {
                System.out.println("[CLIENT] - The result returned from the server is correct");
            } else {
                System.out.println("[CLIENT] - The result returned from the server is NOT correct.");
            }

            a = 4;
            b = 3;
            System.out.println("[CLIENT] - Asking the server what is the ratio of " + a + " and " + b + "...");
            double div = server.divideIntegerNumbers(a, b);
            System.out.println("[CLIENT] - The server has replied that the ration of " + a + " and " + b + " is " + div);

            if (div == a / b) {
                System.out.println("[CLIENT] - The result returned from the server is correct");
            } else {
                System.out.println("[CLIENT] - The result returned from the server is NOT correct.");
            }

            a = 50;
            b = 10;
            System.out.println("[CLIENT - Asking the server what is the answer when " + b + " is subtracted from " + a);
            int sub = server.subtractIntegerNumbers(a, b);
            System.out.println("[CLIENT] - The server has replied that the answer when " + b + " is subtracted from " + a + " is " + sub);
            if (sub == (a - b)) {
                System.out.println("[CLIENT] - The result returned from the server is correct");
            } else {
                System.out.println("[CLIENT] - The result returned from the server is NOT correct.");
            }

            int[] c = {1, 2, 3,5,5,5,5, 4};
            int[] d = {5, 6, 7,4, 8};
            System.out.println("[CLIENT - Asking the server what is the answer when " + Arrays.toString(c) + " is added to " + Arrays.toString(d));
            try {
                int[] ansarr = server.addArray(c, d);
                    System.out.println("[CLIENT] - The server has replied that the answer when " + Arrays.toString(c) + " and " + Arrays.toString(d) + " are added the answer is " + Arrays.toString(ansarr));

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        
             int[] e = {10,20,30,40,50};
            int[] f = {5,10,15,10,25};
            System.out.println("[CLIENT - Asking the server what is the answer when " + Arrays.toString(c) + " is added to " + Arrays.toString(d));
            int[] ansarrdiv = server.divideArray(e,f);
            System.out.println("[CLIENT] - The server has replied that the answer when " + Arrays.toString(c) + " and " + Arrays.toString(d) + " are added the answer is " + Arrays.toString(ansarrdiv));
            
            
        } else {
            System.out.println("[CLIENT] - The Client is NOT connected, the test has failed...");
        }
    }

}
