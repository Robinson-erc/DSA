package misc;


/**
 * Practice using the debugger
 * 
 * @author (sdb) 
 * @version (Jan 2019)
 */
public class Debugger
{
    static int i;
    public static void main (String []args )
    {
    System.out.println ("Starting");
        
        for (i=30; i<200; i++)  
           { method(i);
               System.out.println (i);
            }
        
     System.out.println ("Finished");
    }
    
    private static void method(int parm)
    {   double x= parm;
        while (x>0.0)
            x = x/2;
    }
}
