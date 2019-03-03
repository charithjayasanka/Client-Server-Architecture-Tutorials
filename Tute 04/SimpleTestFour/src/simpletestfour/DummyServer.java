/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Charith Jayasanka
 */
public class DummyServer {
    ArrayList<TemperatureSample> samples=new ArrayList<>();
    String fileName="Sample.ser";
    public boolean isConnected() {
        System.out.println("[SERVER] - Testing if the server is connected...");
        return true;
    }
    
    public void addSample(TemperatureSample s) throws IOException{
        System.out.println("[SERVER] - Adding "+s+" to "+samples);
        samples.add(s);
        System.out.println("[SERVER] - Samples are "+samples);
        saveToFile();
    }
    private void saveToFile() throws FileNotFoundException,IOException{
        System.out.println("[SERVER] - Saving "+samples+" to file "+fileName);
        FileOutputStream file=new FileOutputStream(fileName);
        ObjectOutputStream out=new ObjectOutputStream(file);
        
        out.writeObject(samples);
        
        out.close();
        file.close();
        
        System.out.println("Object has been Serialized");
    }
    
    public double getColdestTemperatureIn(String city){
        double coldest=samples.get(0).value;
        for(TemperatureSample sample:samples){
            if (sample.location.equalsIgnoreCase(city)) {
                if (coldest>sample.value) {
                    coldest=sample.value;
                }
            }
        }
        return coldest;
    }
    
    public double getHottestTemperatureIn(String city){
        double hottest=samples.get(0).value;
        for(TemperatureSample sample:samples){
            if (sample.location.equalsIgnoreCase(city)) {
                if (hottest<sample.value) {
                    
                    hottest=sample.value;
                }
            }
        }
        return hottest; 
    }
    
    public double getAverageTemperature(String city){
        double total=0;
        double count=0;
        for(TemperatureSample sample:samples){
            if (sample.location.equalsIgnoreCase(city)) {
                total+=sample.value;
                count++;
            }
        }
        return total/count; 
    }
    
    public int getNumberOfSamples(String city){
          int count=0;
        for(TemperatureSample sample:samples){
            if (sample.location.equalsIgnoreCase(city)) {
                count++;
            }
        }
        return count;
    }
    
    public double getColdestTemperatureAfter(Date date){
        double coldest=100;
       for(TemperatureSample sample:samples){
           if (sample.time.after(date)) {
              if(coldest>sample.value){
                  coldest=sample.value;
              }
           }
       }
       return coldest;
    }
    
      public double getHottestTemperatureIn(Date date){
        double hottest=0;
       for(TemperatureSample sample:samples){
           if (sample.time.after(date)) {
              if(hottest<sample.value){
                  hottest=sample.value;
              }
           }
       }
       return hottest;
    }
    
}
