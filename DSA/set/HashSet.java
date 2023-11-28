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
        return table.iterator().hasNext();
    }

    @Override
    public void clear() {
        table.clear();
    }
}
