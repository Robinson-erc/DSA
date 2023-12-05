package map;

import list.Iterator;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

/**
 * A map using a binary search tree.
 * Keys must be comparable
 *
 */
public class TreeMap<K extends Comparable,V> implements Map<K, V> {
   //inner class
    class Entry<K extends Comparable, V> implements Comparable<Entry<K, V>>{
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public int compareTo(Entry<K, V> other) {
            return this.key.compareTo(other.key);
        }

    }//end of inner class
    BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree<Entry<K, V>>();

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        return tree.containsKey(entry);
    }

    @Override
    public V get(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);
        if (entry == null) return null;
        return entry.value;
    }
    public V put(K key, V value) {
        Entry<K, V> newEntry = new Entry<K, V>(key, value),oldEntry = tree.get(newEntry);
        if(oldEntry == null) {
            tree = tree.add(newEntry);
            return null;
        }
        oldEntry.value = value;
        V oldValue = oldEntry.value;
        return oldValue;
    }
    public V remove(K key) {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);
        if (entry == null) return null;
        tree = tree.remove(entry);
        return entry.value;
    }
    public int size() {
        return tree.size();
    }
    public boolean isEmpty() {
        return tree.isEmpty();
    }
    public void clear() {
        Iterator<Entry<K, V>> it = tree.iterator();
        while(it.hasNext()) {
            tree.remove(it.next());
        }
        tree = new EmptyBinarySearchTree<Entry<K, V>>();
    }

    @Override
    public K getKey(V value) {
        Entry<K, V> entry = new Entry<K, V>(null, value);
        entry = tree.get(entry);
        if (entry == null) return null;
        return entry.key;
    }
    public String toString() {
        Iterator<Entry<K, V>> it = tree.iterator();
        String s = "";
        while(it.hasNext()) {
            s += it.next().toString() + "\n";
        }
        return s.toString();
    }
}
