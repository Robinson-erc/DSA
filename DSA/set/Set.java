package set;

import list.Iterator;

/**
 * A collection of values with no duplicates and no required order
 * @author sdb & Eric Robinson
 */
public interface Set<E> {
    /**
     * Add a given value to this set, if not already in this set
     * @return true iff it was added
     */
    boolean add(E value);
    /**
     * @return true iff this set contains the given object
     */
    boolean contains(Object obj);
    /**
     * remove the given object from this set if possible
     * @return true iff it was removed
     */
    boolean remove(Object obj);
    /**
     * @return an iterator for this set
     */
    Iterator<E> iterator();
    /** @return the size of this Set */
    int size();

    /** @return true iff this Set is empty */
    boolean isEmpty();

    /** Clear this Set */
    void clear();
    /** @return the union of this Set with the given Set */
    Set<E> union (Set <E> other);

}
