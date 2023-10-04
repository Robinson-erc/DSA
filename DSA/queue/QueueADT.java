package queue;


/**
 * A first in first out list
 *
 * @author SDB&(Eric R)
 * @version (a version number or a date)
 */
public interface QueueADT<E>
{
    /**
     *add the given value to this QueueADT 
     *add the given value at the back of the list
     */
    void add(E value);
    /**
     * return the value at the front of this QueueADT or null if queue is empty
     */
    E peek();
    /**
     * Remove the value at the front of the list
     * Pre:queue is not empty
     */
    E remove();
    /**
     * @return true if queue is empty
     */
    boolean isEmpty();
    /**
     * clear the queue
     */
    void clear();
}
