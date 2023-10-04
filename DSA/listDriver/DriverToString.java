package listDriver;
import list.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

////// Do NOT change the imports

/**
 * Data Structures and Algorithms.
 * Test the toString() method on Lists
 * 
 * @author (sdb) 
 * @version (Sep 2020)
 */
public class DriverToString
{
    public static void main(String [] args)
    {
         
        System.out.println ("Testing the toString() method on ArrayList");
        List<String> strings = new ArrayList<String>();
        test (strings);
 
        //Uncomment the following to test LinkedList
        System.out.println ("Testing the toString() method on LinkedList");
        strings = new LinkedList <String>();
        test (strings);
      System.out.println ("Testing complete.\n");
    }
    
  private static void test(List<String> strings)
  {   System.out.println ("An empty list: " + strings);
      strings.add("mary");
      strings.add("joe");
      strings.add("sue");
      strings.add("joe");
      System.out.println(strings + "\n");       // Should be [mary,joe,sue,joe]
                                                // No trailing comma
     
    }
}
