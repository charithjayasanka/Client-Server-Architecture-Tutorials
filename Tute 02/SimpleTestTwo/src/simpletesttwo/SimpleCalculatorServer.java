/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;
import java.util.*;
/**
 *
 * @author Charith Jayasanka
 */
public class SimpleCalculatorServer {
    public boolean isServerConnected(){
        System.out.println("[SERVER] - Connection is being tested");
        return true;
    }
    
    public int addIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Adding "+a+" and "+b+"...");
        return a+b;
    }
    
     public int subtractIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Subtracting "+b+" from "+a+"...");
        return a-b;
    }
     
      public int multiplyIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Multiplying "+b+" and "+a+"...");
        return a*b;
    }
    
     public double divideIntegerNumbers(double a, double b) throws SimpleCalculatorServerException{
         
         if(b==0){
             throw new SimpleCalculatorServerException("Cannot divide a number to Zero");
         }
         if (a==0 && b==0) {
             throw new SimpleCalculatorServerException("Zero divided by zero is undertermined");
         }
        System.out.println("[SERVER] - Dividing "+a+" and "+b+"...");
        return a/b;
    }
     
     public int [] addArray(int [] arrayA,int [] arrayB) throws IndexOutOfBoundsException {
         if (!(arrayA.length==arrayB.length)) {
             System.err.println("Lengths of the arrays are different");
             throw new IndexOutOfBoundsException();
         }
         int [] addedArray=new int[arrayA.length]; 
         System.out.println("[SERVER] - Adding arrays "+Arrays.toString(arrayA)+" and "+Arrays.toString(arrayB));
         System.out.println();
         for (int i = 0; i < arrayA.length; i++) {
             addedArray[i]=(arrayA[i]+arrayB[i]);
         }
         return addedArray;
     }
        public int [] divideArray(int [] arrayA,int [] arrayB) throws SimpleCalculatorServerException {
         if (!(arrayA.length==arrayB.length)) {
             System.err.println("Lengths of the arrays are different");
             throw new IndexOutOfBoundsException();
         }
         int [] dividedArray=new int[arrayA.length]; 
         System.out.println("[SERVER] - Dividing arrays "+Arrays.toString(arrayA)+" by "+Arrays.toString(arrayB));
         System.out.println();
         for (int i = 0; i < arrayA.length; i++) {
             try {
                 if (arrayB[i] == 0) {
                     throw new SimpleCalculatorServerException("cannot divide a number by Zero");
                 }
             } catch (SimpleCalculatorServerException simpleCalculatorServerException) {
                 System.out.println(simpleCalculatorServerException.getMessage());
             }
             dividedArray[i]=(arrayA[i]/arrayB[i]);
         }
         return dividedArray;
     }
}
