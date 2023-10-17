package sort;

import list.*;

/**
 * Selection Sort Algorithm, to sort in ascending order
 * @author sdb&Eric Robinson
 */
public class SelectionSort<E extends Comparable> implements Sorter<E> {
    List<E> list; //should be arraylist
    public void sort(List<E> list){
        this.list=list;
        for(int start=0; start< list.size()-1;start++){
            swap(posSmallest(start),start);
        }
    }
    /**
     * @return the position of the smallest value beginning at start
     */
    private int posSmallest(int start){
        int result=start;
        for(int i=start+1;i< list.size();i++){
            if(list.get(i).compareTo(list.get(result))<0){
                result =i;
            }

        }
        return result;
    }
    private void swap(int x,int y){
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

}
