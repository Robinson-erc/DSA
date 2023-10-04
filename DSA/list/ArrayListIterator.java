package list;

/**
 * A ListIterator for ArrayLists
 *
 * @author sdb&(Eric Robinson)
 * @version (a version number or a date)
 */
class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E>
{
    //implicit cursor is between positions ndx and ndx+1
    //constructors
    boolean forward=true;
    ArrayListIterator(List<E> list){
        super(list);
    }

    ArrayListIterator(List<E> list, int ndx){
        super(list);
        super.ndx=ndx-1;
    }

    public boolean hasPrevious(){
        return ndx >= 0;
    }

    public E previous(){
        forward=false;
        ndx--;
        return list.get(ndx+1);
    }

    public void remove(){
        if(forward){
            ndx--;
        }
        list.remove(ndx+1);
    }
    public E next(){
        forward=true;
        return super.next();
    }
    public void add(E value){
        list.add(ndx+1,value);
        ndx++;
    }
}
