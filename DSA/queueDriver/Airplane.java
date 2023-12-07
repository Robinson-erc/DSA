package queueDriver;


import org.jetbrains.annotations.NotNull;

/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class Airplane implements Comparable<Airplane>
{  int flight;
   int arrivalTime;
   int fuelLevel;       // gallons of jet fuel remaining
   
   public Airplane (int arrival, int fuel, int flight)
   {    arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this);
        
    }

    @Override
    public String toString() {
        return "[Flight: " + flight + ", Arrival: " + arrivalTime + ", Fuel: " + fuelLevel+ "]";
    }
    //comparing fuel levels. planes with low fuel have higher priority
    //if fuel levels are equal, planes with earlier arrival times have higher priority
    //low fuel is considered less than 4 gallons of fuel


    public int compareTo(Airplane second) {
        if (this.fuelLevel < 4 && second.fuelLevel >= 4) {
            return 1;
        } else if (this.fuelLevel < 4 && second.fuelLevel < 4) {
            if (this.fuelLevel < second.fuelLevel) {
                return 1;
            } else if (this.fuelLevel > second.fuelLevel) {
                return -1;
            } else if (this.fuelLevel == second.fuelLevel) {
                if (this.arrivalTime < second.arrivalTime) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else if (this.fuelLevel >= 4 && second.fuelLevel < 4) {
            return -1;
        } else {
            if (this.arrivalTime > second.arrivalTime) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

   
}
