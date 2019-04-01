/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import java.util.Date;

/**
 *
 * @author Charith Jayasanka
 */
public class TemperatureSample {
    public double value;
    public String location;
    public Date time;

    @Override
    public String toString() {
        return "TemperatureSample{" + "value=" + value + ", location=" + location + ", time=" + time + '}';
    }
}
