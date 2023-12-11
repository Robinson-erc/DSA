package graph;
 import list.*;
 import map.*;
 import java.io.*;
 import java.util.Scanner;

/**
 * Manage network of airline flights
 * Find a path, not necessarily shortest,
 * from an Airport to another Airport.
 * Input is text file of Direct Flights.
 * 
 * @author (sdb) 
 * @version (Apr 2019)
 */
public class Airline
{
    // All the direct flights in a list:
    List <Flight> flights;
    //Keys are airport names, values are airports
    Map <String,Airport> map;
    
    public static void main (String[] args)
    {  Airline airline = new Airline();
       airline.getFlights();
       System.out.println ("Flights: " + airline.flights);
       System.out.println ("Path from PHL to SFO");
       System.out.println (airline.path("PHL","SFO"));
       System.out.println ("Path from Paris to LAX");
       System.out.println (airline.path("Paris","LAX"));
  
    }
    
    // Read in the direct flights from text file "flights.txt"
    // Each line is origin and dest airport separated by one space
    private void getFlights()
    { try { map = new HashMap<String,Airport> ();
       flights = new ArrayList<Flight>();
       File inFile = new File ("flights.txt");
       Scanner scanner = new Scanner(inFile);
       String flight, origin, dest;
       Airport o,d;
       while (scanner.hasNextLine())
        {   
            flight = scanner.nextLine();
            origin = flight.split(" ")[0];
            dest = flight.split(" ")[1];
            if (map.containsKey(origin))
            {   o = map.get(origin);
            }
            else
            {   o = new Airport (origin);
                map.put (origin,o);
            }
            if (map.containsKey(dest))
            {   d = map.get(dest);
            }
            else
            {   d = new Airport (dest);
                map.put (dest,d);
            }
            flights.add (new Flight (o,d));
        }
        scanner.close();
    }
    catch (FileNotFoundException fnfe)
    {   System.err.println (fnfe);  }
    }
    
    /** @return a List of Airports from given origin, to
     *  given dest, or empty List if there is no path
     */
    private List<Airport> path (String origin, String dest)
    { 
        Airport o = map.get(origin);
        Airport d = map.get(dest);
        List<Airport> path = path(o,d);
        return path;
        
    }
    /** @return a List of Airports from given origin, to
     *  given dest, or empty List if there is no path
     */
    private List<Airport> path(Airport origin, Airport dest)
    {
        List<Airport> result = new LinkedList<Airport>();
        origin.visited = true;
        if (origin.equals(dest))
        {   result.add(origin);
            return result;
        }
        Airport port;
        Iterator<Airport> it = getDirect(origin).iterator(); // <--->
        while (it.hasNext()){
            port = it.next();
            result = path(port,dest);
            if (result.size() > 0)
            {   result.add(0,origin);
                return result;
            }
        }
         return result;
    }
    
    /** @return a List of all airports which can be reached
     *  directly from the given airport, from, and which have
     *  not already been visited.
     */
    private List<Airport> getDirect(Airport from)
    {  
        List<Airport> result = new LinkedList<Airport>();

        Flight flight;
        Iterator<Flight> it = flights.iterator();
        while (it.hasNext())
        {   flight = it.next();
            if (flight.origin.equals(from) && !flight.destination.visited)
            {   result.add(flight.destination);
            }
        }
        return result;
        
    }
    
    /** Clear the visited flags in all airports */
    private void clearAirports()
    {
     Flight f;
     Airport port;
     Iterator<Flight> it = flights.iterator(); // <--->
     while (it.hasNext()){
         f = it.next();
         f.origin.visited = false;
         f.destination.visited = false;
     }
    }
                
    
}



