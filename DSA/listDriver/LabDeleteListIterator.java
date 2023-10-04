package listDriver;
import list.*;

/**
 * 
 * @author (sdb and PUT YOUR NAME HERE!) 
 * @version (Feb 2018)
 */
public class LabDeleteListIterator
{
    
    static List <Student> roster;
    
    public static void main()
    {   roster = new ArrayList<Student>();
        System.out.println ("Testing ArrayList");
        test();
        roster = new LinkedList<Student>();
        System.out.println ("Testing LinkedList");
        test();
        System.out.println('\n');
    }
    
    private static void init()
    {   deleteFirstOfDup();
        roster.add (new Student ("mike", 1234));
        deleteFirstOfDup();
        roster.add (new Student ("joseph", 2345));
        roster.add (new Student ("joe", 2345));
        roster.add (new Student ("mary", 3333));
        roster.add (new Student ("maryLou", 3333));
        
    }
    
    private static void test()
    {   
        init();
        System.out.println("Before deletions " + roster);
        deleteFirstOfDup();
        if (roster.size() != 4)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster );
        deleteFirstOfDup();
        if (roster.size() != 3)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster + "\n");
    }
    
    /** Search the roster for the first pair of neighbors which are
     *  equal.  Delete the first member of that pair.
     */
    private static void deleteFirstOfDup()
    {   ///////////  PUT YOUR CODE HERE ///////////////
        if(roster.size()<2){
            return;
        }
        ListIterator<Student> iterator=roster.listIterator();
        Student prevStudent=null;
        Student currentStudent=null;
        while(iterator.hasNext()){
            prevStudent=currentStudent;
            currentStudent=iterator.next();
            if(prevStudent!=null&&prevStudent.equals(currentStudent)){
                iterator.previous();
                iterator.previous();
                iterator.remove();
                return;
            }
        }
    
    }

    
    
        
        
}
