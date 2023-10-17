package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the Bubble Sort algorithm on a linked list.
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class TestBubbleLinked
{
    static List <Integer> grades = new LinkedList <Integer> ();
    static Random rand = new Random();
    
    public static void main (String[] args)
    {
     Sorter sorter;
    
     System.out.println ("Test Bubble Sort on a LinkedList:");
     sorter = new BubbleSortLinked ( );
     testSort (sorter);
     grades.clear();

    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        grades.add (20);
        grades.add (40);
        grades.add (30);
        grades.add (10);
        grades.add (5);
//         grades.add (20);
        
        
        System.out.println ("Before sorting:");
        System.out.println (grades);
        System.out.println ("After sorting:");
        sorter.sort(grades);
        System.out.println (grades + "\n");
        System.out.println ( );
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<20; i++)
             grades.add (rand.nextInt(150));

    }
}
