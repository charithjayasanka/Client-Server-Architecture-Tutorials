/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.Person;

/**
 *
 * @author 2017135
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client client = new Client();
        client.executeTest();
    }

    private void executeTest() {
        if (isConnected()) {
            System.out.println("[CLIENT] - The server is connected...");
            addString("String");
            addString("Another String");
            addString("Yet Another String");
            addString("One more String");
            addString("1");
            addString("Last String");
            String x = findShortestAmongAllStrings();
            System.out.println(x);
            System.out.println(findShortestBetweenWithException("Short", "very very long"));
            try {
                System.out.println(findShortestBetweenWithException(null, "very very long"));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println(findShortestBetweenWithException("short", null));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            try {
                System.out.println(findShortestBetweenWithException(null, null));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            Person person = new Person();
            person.setName("Bob");
            person.setSurname("VeryLongSurnmane");
            System.out.println(findShortestBetweenNameAndSurname(person));
        }
    }

    private static String findShortestAmongAllStrings() {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        return port.findShortestAmongAllStrings();
    }

    private static String findShortestBetween(java.lang.String a, java.lang.String b) {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        return port.findShortestBetween(a, b);
    }

    private static String findShortestBetweenWithException(java.lang.String a, java.lang.String b) {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        return port.findShortestBetweenWithException(a, b);
    }

    private static Boolean isConnected() {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        return port.isConnected();
    }

    private static void addString(java.lang.String a) {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        port.addString(a);
    }

    private static String findShortestBetweenNameAndSurname(server.Person name) {
        server.TestWebservice_Service service = new server.TestWebservice_Service();
        server.TestWebservice port = service.getTestWebservicePort();
        return port.findShortestBetweenNameAndSurname(name);
    }

}
