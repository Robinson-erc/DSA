package mapDriver;
import map.*;


/**
 * Test the HashMap class
 * 
 * @author (sdb) 
 * @version (Apr 2023)
 */
public class LabHashMapDriver
{
    static Map <String, Integer> grades = new HashMap <String, Integer> ();
    
    public static void main(String [] args)
    {   
        
        init ( );
        test (82);          // should be joe
        test (88);          // should be null
        test (95);          // should be alice
        grades.clear();
        test (82);          // should be null
        init ();
        test (82);          // should be joe
        
        System.out.println ("\nTesting complete");
    }

        
     private static void init ()
     {  
        grades.put ("mary", 85);
        grades.put ("joe", 82);
        grades.put ("alice", 95);
        grades.put ("joseph", 68);
        grades.put ("jimmy", 95);
     }
        
     private static void test (int grade)
     {  System.out.print ("Who received " + grade + "? ");
        System.out.println (grades.getKey(grade));   
     }
  
}
