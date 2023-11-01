package sortDriver;
import sort.*;
import list.*;
public class TestingSearch {
    static ArrayList <Integer> nums = new ArrayList <Integer> ();
    public static void main (String [] args){
        ArrayList list=new ArrayList<>();
        list.add(-3);
        list.add(-1);
        list.add(0);
        list.add(5);
        list.add(5);
        list.add(12);
        list.add(23);
        list.add(36);
        list.add(42);
        System.out.println(list);
        BinarySearch searcher=new BinarySearch<>(list);
        int targetOne=searcher.search(5);
        int targetTwo=searcher.search(-3);
        int targetThree=searcher.search(15);
        int targetFour=searcher.search(42);
        int targetFive=searcher.search(200);

    }
}
