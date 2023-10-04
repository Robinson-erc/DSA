package stack;

/**
 *A LIFO list
 *
 * @author SDB&(Eric Robinson)
 * @version (a version number or a date)
 */
public interface StackADT<E>
{
    /**
     *Push a given value on top of this stack 
     *@return value pushed
     */
    E push(E value);

    /**
     * @return the top value from this stackADT
     * Pre: this stack must not be empty
     */
    E peek();

    /**
     * Remove the top value from the stack
     * @return the value removed
     * Pre: the stack must not be empty
     */
    E pop();

    /** @return true iff this Queue is empty */
    boolean isEmpty();
    /**
     * Clear Stack
     */
    void clear();
}
