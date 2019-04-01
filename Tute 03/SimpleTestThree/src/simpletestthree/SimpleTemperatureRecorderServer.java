/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestthree;

import java.util.ArrayList;

/**
 *
 * @author Charith Jayasanka
 */
public class SimpleTemperatureRecorderServer {
    ArrayList temperatures = new ArrayList();
    public boolean isServerConnected(){
        System.out.println("[SERVER] - Testing if the server is connected");
        return true;
    }
    public void addTemperature(double sample){
        temperatures.add(sample);
        System.out.println("[SERVER] - "+temperatures);
    }
    public double getColdestTemperature(){
        double min=0;
        for (int index = 0; index < temperatures.size(); index++) {
            if (min>((double)temperatures.get(index))) {
                min=(double) temperatures.get(index);
                return min;
            }
        }
    }
}
