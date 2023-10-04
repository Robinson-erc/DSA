package listDriver;
import  list.*;


////// Do NOT change the imports

/**
 * Data Structures and Algorithms.
 * Lab 2, Problems 1, 2
 * 
 * @author (sdb) 
 * @version (Sep 2020)
 */
public class DriverNdxOfContains
{
    public static void main(String [] args)
    {
        ////// Testing for efficiency... should take about 5-10 seconds:
        System.out.println ("Testing indexOf(Object), contains(Object) on ArrayList; Please wait...");
        List<String> strings = new ArrayList<String>();
        test1 (strings);
        test (strings);
 
        // Uncomment the following to test LinkedList
        System.out.println ("Testing indexOf(Object), contains(Object) on LinkedList; Please wait...");
        strings = new LinkedList <String>();
        test1 (strings);
        test (strings);
      System.out.println ("Testing complete.\n");
    }
    
  private static void test(List<String> strings)
  {
        int x = strings.indexOf("s32");
        if (strings.indexOf("s" + "32") != 32)
            System.err.println ("Error in indexOf");
        if (!strings.contains("s99"))
            System.err.println ("Error in contains or indexOf");
        if (strings.contains(99))
            System.err.println ("Error in contains or indexOf"); 
}

private static void test1 (List <String> strings)
{   for (int i=0; i<100000; i++)
        strings.add ("s" + i);
    strings.add("end");
    if (! strings.get(3).equals ("s3"))
        System.err.println ("Not correct");
    if (! strings.get(9993).equals ("s9993"))
        System.err.println ("Not correct");
}

}
