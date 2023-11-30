package setDriver;
import set.*;
import list.*;


/**
 * Test the implementations of the Set interface.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabEquals 
{
    public static void main(String [] args)
    {   
        Set <String> friends, pals;
        friends = new TreeSet <String> ();
        pals = new HashSet <String> ();
        System.out.println ("Testing equals (Object)");
        
        if (friends.equals("friends") || pals.equals("pals"))
                System.err.println ("Error in equals 1");
        if (! friends.equals (pals))
            System.err.println ("Error in equals 2");
        if (! pals.equals (friends))
            System.err.println ("Error in equals 3");
            
        friends.add ("joe");
        friends.add ("jim");
        if (friends.equals (pals))
            System.err.println ("Error in equals 4");
        if (pals.equals (friends))
            System.err.println ("Error in equals 5");
            
        friends.add ("joe");
        friends.add (new String ("susie"));
        pals.add ("joe");
        pals.add ("susie");
        pals.add ("jim");
        pals.add ("jimmy");
        
        if (friends.equals (pals))
            System.err.println ("Error in equals 6");
        if (pals.equals (friends))
            System.err.println ("Error in equals 7");
        pals.add ("joe");
        friends.add ("jimmy");
        
         if (! friends.equals (pals))
            System.err.println ("Error in equals 8");
        if (! pals.equals (friends))
            System.err.println ("Error in equals 9");
            
        friends.add("jack");
        pals.add("jill");
        if (friends.equals (pals))
            System.err.println ("Error in equals 10");
        if (pals.equals (friends))
            System.err.println ("Error in equals 11");
        
            System.out.println ("The pals are " + pals);
        System.out.println ("The friends are " + friends);
        System.out.println ("\nTesting complete");
        
    }
}