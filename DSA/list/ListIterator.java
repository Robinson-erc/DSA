package list;

/**
 * Write a description of interface ListIterator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ListIterator<E> extends Iterator<E>
{
    /**
     * @return true if there is a previous value
     */
    boolean hasPrevious();

    /**
     * return previous value 
     * Pre: hasPrevious() is true
     */
    E previous();

    /**
     * remove the last value obtained by next() or previous()
     * Pre: next or prev has been called since the last call to remove
     */
    void remove();

    /** Insert the given value just prior to the implicit cursor position. A subsequent 
    call to previous() should return the inserted value, and a subsequent call to next() should be 
    unaffected.
     */
    public void add (E value);

}
