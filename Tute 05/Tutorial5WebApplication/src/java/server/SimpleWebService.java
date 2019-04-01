/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author 2017135
 */
@WebService(serviceName = "SimpleWebService")
public class SimpleWebService {
String name="CJ_Server";

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        Date timeStamp=new Timestamp(System.currentTimeMillis());
         InetAddress ip = null;
        String hostname = null;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
        return timeStamp+" Hello "+txt+"! from CJ Server\nYour current IP address : "+ ip+"\nYour current Hostname : " + hostname;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isConnected")
    public Boolean isConnected() {
        System.out.println("[SERVER] - Testing if the Server is connected");
        //TODO write your implementation code here:
        return true;
    }

    

}
