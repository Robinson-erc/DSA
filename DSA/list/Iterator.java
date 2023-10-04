package list;
/**
 * Permit the client to visit every value in a collection
 * @author sdb&Eric Robinson
 */

public interface Iterator<E>
{
 /**
  * @return true if there are more values to be visited
  */
 
 boolean hasNext();
 
 /**
  * @return next value to be visted 
  * Pre: hasNext() is true
  */
 E next();
 
 /**
  * @Remove the last value returned by next()
  * Pre: next has been called atleast once since last call to remove()
  */
 void remove();
}
