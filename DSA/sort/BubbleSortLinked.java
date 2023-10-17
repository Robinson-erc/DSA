package sort;
import list.*;

/**
 * Sort a linkedlist with bubblesort in time O(n^2)
 * @author sdb&Eric Robinson
 */
public class BubbleSortLinked<E extends Comparable> implements Sorter<E> {
    List<E> list; //should be a linked list
    public void sort(List<E> list){
        this.list=list;
        E left;
        E right;
        ListIterator<E> lit;
        for(int i=0;i< list.size()-1;i++)
        {
            lit= list.listIterator();
            right=lit.next();
            for (int j=0;j< list.size()-i-1;j++){
                left=right;
                right=lit.next();
                if(left.compareTo(right)>0){
                    lit.remove();
                    lit.previous();
                    lit.add(right);
                    right=lit.next();
                }
            }
        }
    }
    private void swap(int x,int y){
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }
}
