package hash;

import list.ArrayList;
import list.Iterator;
import list.LinkedList;
import list.List;

/**
 * A hash table provides quick access to keys.
 * Client should implement a method known as hashCode()
 * which returns an int.
 * Duplicates permitted
 * If key1 equals key2, then the hashCode() method
 * must return the same int.
 * If not equal, the table is efficient if hashCode()
 * returns different ints.
 * WorstCase Peformance= O(n) few long lists, lots of collisions
 * Avg Case Performance= O(1) many short lists, few collisions
 * @author sdb & Eric Robinson
 */
public class HashTable <K>{
    List<List<K>> lists;
    int size = 0; //number of keys

    public HashTable() {
        this(10);
    }

    public HashTable(int cap) {
        lists= new ArrayList<List<K>>(cap);
        for (int i=0; i<cap;i++) lists.add(new LinkedList<K>());
    }
    /**
     * @return true iff the given obj is a key in this HashTable
     */
    public boolean containsKey(Object obj){
        List<K> list = getList(obj);
        return list.contains(obj);
    }
    public List<K> getList(Object obj){ //runtime = O(1)
        int code = obj.hashCode();
        code = Math.abs(code);
        //if (lists.size()==0) return lists.get(0); //i added this in
        code = code % lists.size();
        return lists.get(code);
    }
    /**
     * Add the given key to this HashTable
     * Duplicates permitted
     */
    public void put(K key){
        List<K> list = getList(key);
        list.add(key);
        size++;
    }
    /**
     * @return a key from the HashTable
     * which equals the given key, or null
     * if not found
     */
    public K get(K key){
        List<K> list = getList(key);
        K tableKey;
        Iterator<K> it = list.iterator();
        while(it.hasNext()){
            tableKey=it.next();
            if (key.equals(tableKey)) return tableKey;
        }
        return null; //not found
    }

    /**
     * Remove the given object from this HashTable
     * @return true iff it was removed
     */
    public boolean remove(Object obj) {
        List<K> list = getList(obj);
        boolean result = list.remove(obj);
        if (result) size--;
        return result;
    }
    /** @return the size of this HashTable */
    public int size(){
        return size;
    }
    /** @return true iff this HashTable is empty */
    public boolean isEmpty(){
        return size==0;
    }
    /** Clear this HashTable */
    public void clear(){
        for (int i =0; i < lists.size(); i++){
            lists.set(i, new LinkedList<K>());
        }
        size=0;
    }


    public Iterator<K> iterator() {
      return new TableIterator<K>(this);
    }

    public String toString() {
        String result = "[";
        TableIterator<K> it = new TableIterator<K>(this);
        while (it.hasNext()) {
            result += it.next().toString();
            if (it.hasNext()) {
                result +=(", ");
            }
        }
        result += "]";
        return result.toString();
    }
}
