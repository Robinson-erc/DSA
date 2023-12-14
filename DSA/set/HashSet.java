package set;

import hash.HashTable;
import list.Iterator;

/**
 * A set implemented with a HashTable
 */
public class HashSet<E> implements Set<E> {
    HashTable<E> table = new HashTable<E>();
    @Override
    public boolean add(E value) {
        if (table.containsKey(value)) return false;
        table.put(value);
        return true;
    }

    @Override
    public boolean contains(Object obj) {
        return table.containsKey(obj);
    }

    @Override
    public boolean remove(Object obj) {
        return table.remove(obj);
    }

    @Override
    public Iterator<E> iterator() {
        return table.iterator();
    }
    public int size(){
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public void clear() {
        table.clear();
    }

    @Override
    public Set<E> union(Set<E> other) {
        HashSet<E> result = new HashSet<>();
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        it = other.iterator();
        while (it.hasNext()) {
            result.add(it.next());
        }
        return result;
    }

    public boolean equals(Object obj){
        if(! (obj instanceof Set)) return false;
        if(this == obj) return true;
        Iterator<E> it = iterator();
        if (obj instanceof Set) {
            Set<E> other = (Set<E>) obj;
            if (this.size() != other.size()) return false;
            while (it.hasNext()) {
                if (!other.contains(it.next())) return false;
            }
            return true;
        }
       // while (it.hasNext()) {
        //    if (!obj.equals(it.next())) return false;
      //  }
        return true;
    }

    public String toString(){
        return table.toString();
    }
}
