/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.lang.NullPointerException;

/**
 *
 * @author 2017135
 */
@WebService(serviceName = "testWebservice")
public class testWebservice {

    static ArrayList<String> stringsCollection = new ArrayList<>();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        //TODO write your implementation code here:
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetween")
    public String findShortestBetween(@WebParam(name = "a") String a, @WebParam(name = "b") String b) {
        //TODO write your implementation code here:
        return (a.length() > b.length() ? b : a);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetweenWithException")
    public String findShortestBetweenWithException(@WebParam(name = "a") String a, @WebParam(name = "b") String b) throws IllegalArgumentException {
        //TODO write your implementation code here:

        if (a == null) {
            throw new NullPointerException();
        }
        if (b == null) {
            throw new NullPointerException();
        }

        return (a.length() > b.length() ? b : a);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addString")
    public void addString(@WebParam(name = "a") String a) {
        //TODO write your implementation code here:
        System.out.println("Added");
        this.stringsCollection.add(a);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestAmongAllStrings")
    public String findShortestAmongAllStrings() {
        //TODO write your implementation code here:
        String shortest = stringsCollection.get(0);
        System.out.println(stringsCollection.size());
        for (String item : this.stringsCollection) {
            if (shortest.length() > item.length()) {
                shortest = item;
            }
        }
        return shortest;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findShortestBetweenNameAndSurname")
    public String findShortestBetweenNameAndSurname(@WebParam(name = "name") Person name) {
        //TODO write your implementation code here:
        Person person = name;

        if (person.getName().length() > person.getSurname().length()) {
            return person.getSurname();
        } else {
            return person.getName();
        }
    }

}
