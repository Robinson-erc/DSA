package queue;
import list.*;

/**
 * Write a description of class ArrayQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayQueue<E> implements QueueADT<E>
{
    List<E> list=new ArrayList<E>();
    int size=0;
    int front=0;
    int back=0;
    public void add(E value){
        if(list.size()!=size)//clobber
        {
            list.set(back,value);
           back=(back+1)%list.size();

        }
        else{
            list.add(back,value);
            front=(front+1)%list.size();
           back=(back+1)%list.size();

        }
        size++;
    }

    public E peek(){
        if(list.isEmpty()){
            return null;
        }
        return list.get(front);
    }

    public E remove(){
        E result=list.get(front);
        front=(front+1)%list.size();
        size--;

        return result;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void clear(){
        list.clear();
        front=0;
        back=0;
        size=0;

    }
    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }
        String result = "["+ list.get(front%list.size()).toString();
        for(int i = 1; i <size; i++) {
            result = result + ", " + list.get((front+i)%list.size());
        }
        result = result + "]";
        return result;
    }
    public int size(){
        return size;
    }
}
