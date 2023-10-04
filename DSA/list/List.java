package list;

/**
 *A list is an ordered collection; duplicates
 *permitted
 *@author Eric Robinson
 */
public interface List<E>
{
    /**
     * @ return the value at given ndx
     * @ param 0 <= ndx < size
     */ 
    E get(int ndx);

    /**
     * change the value at given ndx to the given value
     * @param
     * @return the old value
     */
    E set(int ndx, E value);

    /**
     * add the given value at the end of the list
     */
    void add(E value);

    /**
     * Insert the given value at given ndx
     * @param 0<=ndx<=size
     */
    void add(int ndx, E value);

    /**
     * remove the value at the given ndx
     * @return the value removed
     * @param 0<=x<size
     */
    E remove(int ndx);

    /** @return the size of this List */

    int size();

    /** @return true iff this List is empty */

    boolean isEmpty();

    /** Clear this List */

    void clear();

    /** @return the index of the first occurrence of the given object in this List, or -1 if not found */
    int indexOf(Object obj);

    /** @return true iff this List contains the given object */
    boolean contains(Object obj);

    /**
     * return an iterator for this list
     */
    Iterator<E>iterator();

    /** @return true iff the first value in this List is duplicated */
    boolean firstIsDuplicated();

    /** Remove the first occurrence of obj from this List, if possible.
    @return true iff the object was removed
     */
    boolean remove (Object obj);

    /** @return true iff the given Object is a List and this List is equal to the given List. */
    public boolean equals (Object obj);
    /**
     * return a ListIterator for this list
     */
    ListIterator<E> listIterator();
    /**
     * @return a ListIterator for this list beginning at the given ndx use size to begin at end
     */
    ListIterator<E> listIterator(int ndx);
}
