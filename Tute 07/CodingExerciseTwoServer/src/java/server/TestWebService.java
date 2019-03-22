/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Timestamp;
import java.util.Date;
import java.lang.NullPointerException;

/**
 *
 * @author 2017135
 */
@WebService(serviceName = "TestWebService")
public class TestWebService {

    /**
     * This is a sample web service operation
     */
    String sName = "Server CJ";

    @WebMethod(operationName = "isConnected")
    public String isConnected(String cName) throws ExceptionCustom {

        if (cName == null) {
            System.out.println("exception thrown");
            throw new ExceptionCustom("No Input Detected");

        }
        Date timeStamp = new Timestamp(System.currentTimeMillis());

        System.out.println("[SERVER] - Server is connected");

        return timeStamp + "SERVER - " + sName + " -Connection from Client " + cName + " succeeded.";
    }

    @WebMethod(operationName = "sendMessage")
    public String sendMessage(@WebParam(name = "message") String message) {

        System.out.println("[SERVER] - Server has recieved message: " + message);
        return "Server has recieved" + message;
    }
}
