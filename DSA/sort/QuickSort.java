package sort;

import list.*;

/**
 * Quicksort Algorithm to sort an ArrayList ascending.
 * @author sdb & Eric Robinson
 */
public class QuickSort<E extends Comparable> implements  Sorter<E> {

    List<E> list;
    @Override
    public void sort(List<E> list) {
        this.list=list;
        qSort(0,list.size()-1);

    }
    private void qSort(int start, int end){
        if(end-start<1){
            return;
        }
        int p = partition(start,end);
        qSort(start,p-1);//left part
        qSort(p+1,end);//right part

    }

    /**
     * Post:All values to the left of the pivot are smaller than the pivot
     * And all values to the right of the pivot are greater or equal to the pivot
     * @return position of the pivot value
     * @author sdb&Eric Robinson
     */
    private int partition(int start, int end){
        int p = start; //p Pivot position
        E pivot=list.get(p);
        for (int i =start+1;i<=end; i++){
            if(list.get(i).compareTo(pivot)<0){
                list.set(p,list.get(i));
                p++;
                list.set(i,list.get(p));
            }
            list.set(p,pivot);
        }
        return p;
    }
}
