package map;

/**
 * A collection of entries, each of which has a key and a value. Access is fast by key
 * @author sdb & Eric Robinson
 */
public interface Map <K,V>{
    /**
     * @return true iff given key is in the map
     */
    boolean containsKey(K key);
    /**
     * @return the value associated with the given key, or null if it is not in the map
     */
    V get(K key);
    /**
     * put an entry into this map with the given key and value
     * @return the old value associated with the given key, or null if it is not in the map
     */
    V put(K key, V value);
    /**
     * remove an entry from this map with the given key
     * @return its value or null if it is not in the map
     */
    V remove(K key);
    /** @return the size of this Map */
    int size();

    /** @return true iff this Map is empty */
    boolean isEmpty();

    /** Clear this Map */
    void clear();

}
