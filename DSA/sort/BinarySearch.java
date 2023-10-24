package sort;

import list.*;

/**
 * Search a sorted ArrayList
 * for a given target
 * @author sdb&Eric Robinson
 */
public class BinarySearch <E extends Comparable> {
List<E> list; //should be a sorted ArrayList
E target;
    public BinarySearch(List<E> list) {
        this.list = list;

    }

    /**
     * @param target
     * @return position of some occurennce of target in list,
     * or -1 if not found
     */
    public int search(E target){
        this.target=target;
        return binSearch(0,list.size()-1);
    }

    private int binSearch(int start, int end) {
        if(start>end)
            return -1; //not found

        int mid=(start+end)/2;
        int cmp =target.compareTo(list.get(mid));

        if(cmp==0)
            return mid;
        if(cmp<0)
            return binSearch(start,mid-1);
        return binSearch(mid+1,end);

    }


}
