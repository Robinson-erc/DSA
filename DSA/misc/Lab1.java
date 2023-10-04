package misc;
import java.util.*;


/**
 * Work with lists
 * 
 * @author (sdb)
 * @author (PUT YOUR NAME HERE)
 * @version (Fall 2020)
 */
public class Lab1
{   static int MAX = 1000000;
    public static void main()
    {
        List<Integer> myList = new LinkedList<Integer>();
        init (myList);
        System.out.println ("First 20 numbers before removing evens");
        show (myList,20);
        deleteEvens(myList);
        System.out.println ();
        System.out.println ("First 20 numbers after removing evens");
        show (myList,20);
        System.out.println ("\n\nsize is now " + myList.size());
    }
    /**
     *  Delete all even numbers from the given list
     */
    private  static void deleteEvens(List<Integer> aList)
    {
       //PUT YOUR CODE HERE
     Iterator <Integer> iterator= aList.iterator();
     while(iterator.hasNext()){
         int num=iterator.next();
         if(num%2==0){
             iterator.remove();
         }
     }
    }
  
//     Initialize the given list with MAX integers
    private static void init (List<Integer> aList)
    {
        Random rand = new Random(1);
        for (int i=0; i<MAX; i++)
            aList.add(rand.nextInt(100));
    }
    
//     Display the first max numbers from the given List on stdout
    private static void show (List<Integer> aList, int max)
    {
        for (int i=0; i<max; i++)
            System.out.print (aList.get(i) + " ");
    }
    
    
}
