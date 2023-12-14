package stack;
import list.*;

/**
 * A StackADT implemented with a list
 * A Last In First Out (LIFO) list
 * @author SDB &(your name)
 * @version (a version number or a date)
 */
public class Stack<E> implements StackADT<E>
{
    List<E> list=new ArrayList<E>();
    //position 0 in the list is the bottom of the stack
    public Stack(boolean result){
        
        if(true){
            List<E> list=new ArrayList<E>();
        }
        else{
            List<E> list=new LinkedList<E>();
        }
    }

    public E push(E value){
        list.add(value);
        return value;
    }

    public E peek(){
        return list.get(list.size()-1);
    }

    public E pop(){
        return list.remove(list.size()-1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public String toString(){
        return list.toString();
    }

    public void clear(){
        list.clear();
    }
}
