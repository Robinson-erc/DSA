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
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
        front=0;
        back=0;
        size=0;

    }

    //public String toString() {
      //  StringBuilder result= new StringBuilder("[");
        //int f=front;
        //int b=back;
        //if(list.isEmpty()){
        //return "[]";
        //}
        //result.append(list.get(front).toString());
        //for(int i=0;i<size;i++){
          //  result.append(", ").append(list.get(f));
            //f=(f+1)%list.size();
            //b=(b+1)%list.size();
        //}
         //for(int i=(front+1)%list.size();i != back; i= (i+1)%list.size()){
         //result.append(", ").append(list.get(i));

         //}
        //return result + "]";
       
    //}
    @Override
    public String toString() {
        if(size == 0) {
            return "[]";
        }
        String result = "["+ list.get(front%list.size()).toString();
        for(int i = 1; i <size; i++) {
            //front=(front+i)% list.size();
            //back=(back+1)% list.size();
            //list.get(front+i);

            result = result + ", " + list.get((front+i)%list.size());
        }
        result = result + "]";
        return result;
    }
}
