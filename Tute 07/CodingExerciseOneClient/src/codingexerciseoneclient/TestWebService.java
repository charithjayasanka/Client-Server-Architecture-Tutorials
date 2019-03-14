/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexerciseoneclient;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gab
 */
@WebService(serviceName = "TestWebService")
public class TestWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "testConnection")
    public Boolean testConnection() 
    {
        System.out.println("[SERVER] - Testing Connection");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sendMessage")
    public String sendMessage(@WebParam(name = "message") String message) 
    {
        System.out.println("[SERVER] - Received: " + message);
        return "Server has received " + message;
    }
}
