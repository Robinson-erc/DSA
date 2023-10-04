package list;
import java.util.Set;

/**
 * An iterator for ArrayLists
 *
 * @author sdb(Eric Robinson)
 */
public class ArrayIterator<E> implements Iterator<E>
{
    int ndx=-1; 

    List<E> list;

    ArrayIterator(List<E> list){
        this.list=list;
    }

    public boolean hasNext(){
        if(ndx<list.size()-1)
            return true;
        return false;
    }

    public E next(){
        ndx++;
        return list.get(ndx);
    }

    public void remove(){
        list.remove(ndx);
        ndx--;
    }
}
