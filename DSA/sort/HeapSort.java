package sort;
import list.*;

/**
 * HeapSort Algorithm. List should be an ArrayList
 * @author sdb & Eric Robinson
 *
 */
public class HeapSort<E extends Comparable> implements Sorter<E> {
    List<E> list;
    @Override
    public void sort(List<E> list) {
        this.list=list;
        heapify(0);
        int last= list.size()-1;
        while(last>0){
            swap(0,last);
            last--;
            percDown(0,last);
        }
    }

    public   void percDown (int root, int max)
    {
        int bc = biggerChild (root, max);
        while (2*root+1 <= max && greater (bc, root))
        {
            swap (root, bc);
            root = bc;
            bc = biggerChild (root, max);
        }
    }
    //bc is the position of the roots bigger child
    private boolean greater(int x, int y){
        return list.get(x).compareTo(list.get(y))>0;
    }

    private int biggerChild(int root, int max) {
        int left= 2*root+1;
        int right = 2*root+2;
        if (right> max) return left;
        if(greater(left,right)) return left;
        return right;
    }

    /**
     *Make this list a heap
     * @param
     */
    private void heapify(int root) {
        if(root>list.size()-1)return;
        heapify(2*root+1);
        heapify(2*root+2);
        percDown(root, list.size()-1);
    }
    private void swap(int x,int y){
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }
}
