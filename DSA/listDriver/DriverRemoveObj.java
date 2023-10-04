package listDriver;
import list.*;
import java.util.Random;
////// Do NOT change the imports

/**
 * Data Structures and Algorithms.
 * Test the toString() method on Lists
 * 
 * @author (sdb) 
 * @version (Sep 2020)
 */
public class DriverRemoveObj
{
    public static void main(String [] args)
    {
        System.out.println ("Testing the remove(Object) method on ArrayList");
        List<String> strings = new ArrayList<String>();
        test (strings);
        test2 (strings);

        //Uncomment the following to test LinkedList
        System.out.println ("\nTesting the remove(Object) method on LinkedList");
        strings = new LinkedList <String>();
        test (strings);
        test2 (strings);
        System.out.println ("\nTesting complete.\n");
    }

    private static void test(List<String> strings)
    {   strings.add("mary");
        strings.add("joe");
        strings.add("sue");
        strings.add("joe");
        System.out.println(strings);                      // Should be [mary,joe,sue,joe]

        System.out.println ("joe was removed: " + strings.remove("joe"));   // Should be true
        System.out.println (strings);                     // Should be [mary,sue,joe]
        strings.remove("ma" + "ry");
        System.out.println ("Mary was removed: " + strings.remove("Mary"));
        if (strings.size() != 2)
            System.err.println ("Error, possibly in remove");
        System.out.println (strings);             //  should be [sue,joe]
    }

    private static void test2 (List<String> strings)
    {   int max = 100000;
        Random rand = new Random(10);
        System.out.println("Testing for efficiency...");
        for (int i=0; i<max; i++)
            strings.add("str" + i);
        int n = 1000;
        for (int i=0; i<100; i++)
            strings.remove("str" + rand.nextInt(max));
        for (int i=0; i<10000; i++)
            strings.remove("Str33");
        System.out.println("After removes, size of the list is now " + strings.size());
    }

}
