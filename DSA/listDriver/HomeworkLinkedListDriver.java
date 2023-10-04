package listDriver;

import list.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Test the List ADT.
 * 
 * @author (sdb) 
 * @version (Sep 2018)
 */
public class HomeworkLinkedListDriver
{
    public static void main(String [] args)
    {   
    List <String> names;
    System.out.println ("Testing LinkedLists");
    names = new LinkedList <String> ();
    names.add ("jim");
   names.add ("mary");
   names.add ("joe");
   names.add ("sue");
   System.out.println (names.get(2));  // Should be joe
   names.set (2, "Joe");            
   System.out.println (names.get(2));  // Should be Joe
   System.out.println (names.size());  // Should be 4
   names.remove (0);
   System.out.println (names.size());  // Should be 3
   names.add (2, "Sue");
   System.out.println (names.get(2));  // Should be Sue
   names.add (2, "mary"); 
   
   if (names.size() != 5)
        System.err.println ("Incorrect size");
   if (names.contains ("Mary"))
        System.err.println ("Error in contains");
   if (names.indexOf("mary") != 0)
        System.err.println ("Error in indexOf");
   if (!names.contains (new String ("sue")))
        System.err.println ("Error in contains");
   if (names.contains (names))
        System.err.println ("Error in contains");
   if (!names.get(4).equals ("sue"))
        System.err.println ("Error in get");
   if (names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty");
       names.add(5,"jimmy");
   // System.out.println ("The names are " + names);
   
   names.clear();
   // System.out.println ("Empty list: " + names);
   if (!names.isEmpty())
        System.err.println ("Incorrect, error in isEmpty() or clear()");
   names.add("name1");
   names.add("name2");
   if (! (names.get(1).equals("name2")))
    System.err.println ("Error, possibly in clear())");
   
}
  
}
