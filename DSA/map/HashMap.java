package map;
import hash.*;
public class HashMap<K, V> implements Map<K, V> {

    //beginning of inner class
    class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public boolean equals(Object obj){
            Entry<K,V> other = (Entry<K,V>) obj;
            return key.equals(other.key);
        }
        public int hashCode(){
            return key.hashCode();
        }
        @Override
        public String toString() {
             return "[" + key + ", " + value + "]";
        }
        //end of inner class
    }
    HashTable<Entry<K, V>> table = new HashTable<Entry<K, V>>();

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> entry = new Entry<K,V>(key, null);
        return table.containsKey(entry);
    }
    public V get(K key){
        Entry<K, V> entry = new Entry<K,V>(key, null);
        entry = table.get(entry);
        if (entry == null) return null;
        return entry.value;
    }
    public V put(K key, V value){
        Entry<K, V> newEntry  = new Entry<K,V>(key, value);
        Entry<K, V> oldEntry = table.get(newEntry);
        if (oldEntry != null) {
            V oldValue = oldEntry.value;
            oldEntry.value = value;
            return oldValue;
        }
        table.put(newEntry);
        return null;
    }
    public V remove(K key){
        Entry<K, V> entry = new Entry<K,V>(key, null);
        entry = table.get(entry);
        if (entry == null) return null;
        table.remove(entry);
        return entry.value;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public void clear() {
        table.clear();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public String toString() {
        return table.toString();
    }

    @Override
    public K getKey(V value) {
        Entry<K, V> entry = new Entry<K,V>(null, value);
        entry = table.get(entry);
        if (entry == null) return null;
        return entry.key;
    }
}