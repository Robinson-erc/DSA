package map;
import hash.*;
import list.Iterator;
import set.*;
import java.security.Key;

public class HashMap<K, V> implements Map<K, V> {
    K key;
    V value;
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
             return "" + key + "=" + value + "";
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
        Iterator<Entry<K,V>> it = table.iterator();
        while(it.hasNext())
        {
            Entry<K,V> entry = it.next();
            if(entry.value.equals(value)) return entry.key;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Iterator<Entry<K,V>> it = table.iterator();
        while(it.hasNext())
        {
            Entry<K,V> entry = it.next();
            keys.add(entry.key);
        }
        return keys;
    }

    @Override
    public boolean equals(Object obj) {
        Map<K, V> other = (Map<K, V>) obj;
        if (this.size() != other.size()) return false;
        Iterator<Entry<K,V>> it = table.iterator();
        while(it.hasNext())
        {
            Entry<K,V> entry = it.next();
            if(!other.containsKey(entry.key) || !other.get(entry.key).equals(entry.value)) return false;
        }
        return true;
    }
}