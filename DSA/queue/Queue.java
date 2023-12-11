package queue;
import list.*;

/**
 * A QueueADT implemented with a list
 * A first in first out list
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue<E> implements QueueADT<E>
{
    List<E> list=new LinkedList<E>();
    public void add(E value){
        list.add(value); //adding position at 0
    }
    public E peek(){
        if(list.isEmpty()){
            return null;
            
        }
        return list.get(0);
    }
    public E remove(){
        return list.remove(0);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void clear(){
        list.clear();
    }
    public String toString(){
        return list.toString();
    }

    @Override
    public int size() {
        return list.size();
    }
}
