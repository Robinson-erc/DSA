package hash;

import list.Iterator;
import list.List;

/**
 * An iterator for HashTable
 * Will allow us to visit every key
 * in a hash table
 * @author sdb & Eric Robinson
 */
public class TableIterator<K> implements Iterator<K> {
    HashTable<K> table;
    int ndx=0;
    Iterator<K> it;//iterator for a linkedList
    TableIterator(HashTable<K> table){
        this.table=table;
        setIt(0);
    }

    /**
     * set the iterator (it) to the linkedList
     * at the given position in the arrayList
     * @param ndx
     */
    private void setIt(int ndx) {
        List<K> list = table.lists.get(ndx);
        it = list.iterator();
    }

    @Override
    public boolean hasNext() {
        if (it.hasNext()) return true;

        return nextList()>=0;
    }

    /**
     * return the position of the next nonempty linkedList in the table
     * @return -1
     */
    private int nextList() {
       for (int i=ndx+1; i < table.lists.size();i++){
           List<K> list = table.lists.get(i);
           if (!list.isEmpty()) return i;
       }
        return -1;
    }

    @Override
    public K next() {
        if (!it.hasNext()){
            ndx = nextList();
            setIt(ndx);
        }
        return it.next();
    }

    @Override
    public void remove() {
        it.remove();
        table.size--;
    }
}
