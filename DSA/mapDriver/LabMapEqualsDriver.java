package mapDriver;
import map.*;

/**
 * Test the Map classes
 * 
 * @author (sdb) 
 * @version (Nov 2016)
 */
public class LabMapEqualsDriver
{
    public static void main(String [] args)
    {  Map <String, String> friends = new TreeMap <String, String> ();
        Map <String, String> pals = new HashMap <String, String> ();
 
        init (friends);
        if (friends.equals(pals))
            System.err.println ("error");
         if (pals.equals(friends))
            System.err.println ("error");
        init (pals);
        if (!friends.equals(pals))
            System.err.println ("error");
         if (!pals.equals(friends))
            System.err.println ("error");

         System.out.println ("jim is not a pal: " + pals.remove("jim"));    // 215
         if (friends.equals(pals))
            System.err.println ("error");
         if (pals.equals(friends))
            System.err.println ("error");
         System.out.println ("jim is not a friend: " + friends.remove("jim"));  // 215
          if (!friends.equals(pals))
            System.err.println ("error");
         if (!pals.equals(friends))
            System.err.println ("error");
         
    System.out.println ("friends: " + friends); // [sarah=215,stu=609,sue=609,will=856]
    System.out.println ("pals: " + pals + "\n");   // [will=215,van=856,sarah=215,sue=609]
         
         pals.put("will","215");
         if (pals.equals(friends))
            System.err.println ("error");
         if (friends.equals(pals))
            System.err.println ("error");
         pals.put("will","856");
         
         friends.remove("van");
         pals.remove("stu");
         if (pals.equals(friends))
            System.err.println ("error");
         if (friends.equals(pals))
            System.err.println ("error");
         pals.put("will", "215");
         if (pals.equals(friends))
            System.err.println ("error");
         if (friends.equals(pals))
            System.err.println ("error");
         
         System.out.println ("friends are " + friends); // [sarah=215,stu=609,sue=609,will=856]
         System.out.println ("pals are " + pals + "\n");   // [will=215,van=856,sarah=215,sue=609]
                                                    // HashMap: order may vary
         
    }
    
    private static void init (Map<String, String> people)
    {        
        people.put ("sue", "609");
        people.put ("jim", "856");
        people.put ("sarah", "215");
        people.put ("will", "856");
        people.put ("stu", "609");
        people.put ("van", "856");
        people.put (new String ("jim"), "215");
        System.out.println (people);
    }
    
  
}
