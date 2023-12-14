package listDriver;
import list.*;

/**
 * Determine whether a given List is a heap.
 *
 * @author (sdb)
 * @version (Apr 2023)
 */
public class HeapTester
{
    List<Integer> list;
    
    public static void main(String [] args)
    {
     HeapTester tester = new HeapTester();
     tester.checkLists();
     System.out.println ("Testing complete");
    }
     void checkLists()
     {   init1();        
         test(list,true);        // The list is a heap
         list.add(32);
         test (list,false);    // The list is not a heap
         init2();
         test (list,true);      // The list is a heap
         list.add(10000000);
         test (list,false);     // The list is not a heap
    }
    
    
    private void test(List<Integer> list, boolean ok)
    {   if (isAheap(list) != ok)
            System.err.println ("Error in isAheap(List)" );
    }
    
    /** @return true iff the given List is a heap
     *  @author  PUT YOUR NAME HERE
     */
    public boolean isAheap (List<Integer> list)
    {    

        //////////  PUT YOUR CODE HERE
        int size = list.size();

        if (size == 0) {
            return true;
        }

        for (int i = (size - 2) / 2; i >= 0; i--) {
            int parent = list.get(i);
            int leftChild = list.get(2 * i + 1);
            int rightChild = 2 * i + 2 < size ? list.get(2 * i + 2) : Integer.MIN_VALUE;

            if (parent < leftChild || parent < rightChild) {
                return false;
            }
        }

        return true;
        }
    
    
    //// Initialization methods
    private void init1()
    {
     list = new ArrayList<Integer>();
     list.add (40);
     list.add (35);
     list.add (39);
     list.add (32);
     list.add (32);
     list.add (39);
     list.add (15);
     list.add (32);
     list.add (32);
     list.add (32);
     list.add (32);
     list.add (32);
     list.add (32);     
    }
    
    private void init2()
    {   list = new ArrayList<Integer>();
        for (int i=10000000; i>-100000; i--)
            list.add(i);
    }
}
