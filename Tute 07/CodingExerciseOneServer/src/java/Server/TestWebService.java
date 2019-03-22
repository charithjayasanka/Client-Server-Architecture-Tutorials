/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Timestamp;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Gab
 */
@WebService(serviceName = "TestWebService")
public class TestWebService {

    String serverName = "CJ Server";

    /**
     * Web service operation
     */
    @WebMethod(operationName = "testConnection")
    public Boolean testConnection(String name) {
        Date timeStamp = new Timestamp(System.currentTimeMillis());
        System.out.println("[SERVER - " + serverName + "] - Testing Connection");
        System.out.println(timeStamp + " Connection from client " + name + " succeded");
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sendMessage")
    public String sendMessage(@WebParam(name = "message") String message) {
        System.out.println("[SERVER] - Received: " + message);
        return "Server has received " + message;
    }
}
