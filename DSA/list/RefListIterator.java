package list;

/**
 * A ListIterator for LinkedLists
 *
 * @author sdb&(Eric Robinson)
 * @version (a version number or a date)
 */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>
{
    //super.cursor is a ref to node
    //containing last value obtained by calling next() or previous()
    private boolean forward=true;
    //constuctors
    RefListIterator(LinkedList<E> list){
        super(list);
    }

    RefListIterator(LinkedList<E> list, int start){
        super(list);
        for(int i=0;i<start;i++){
            cursor=cursor.next;
        }
    }

    public boolean hasNext(){
        if(list.isEmpty()){
            return false;
        }
        if(forward){
            return cursor.next != list.tail;
        }
        return false;
    }

    public E next(){
        if(forward){
            cursor=cursor.next;
        }
        forward=true;
        return cursor.value;
    }

    public boolean hasPrevious(){
        if(!forward)
        {
            return cursor.prev != list.head;
        }
        //initial call to hasPrevious()
        return cursor != list.head;
    }

    public E previous(){
        if(!forward){
            cursor=cursor.prev;
        }
        forward=false;
        return cursor.value;
    }

    public void remove(){
        super.remove();
        if(forward){
            cursor=cursor.prev;
        }
        else{
            cursor=cursor.next;
        }
    }

    public void add(E value) {
        
        if(forward){
            Node<E> temp=new Node<E>(value,cursor.next,cursor);
            cursor.next.prev=temp;
            cursor.next=temp;
            cursor=cursor.next;
            list.size++;
        }
        else{
            Node<E> temp = new Node<E>(value,cursor,cursor.prev);
            cursor.prev.next=temp;
            cursor.prev=temp;
            list.size++;
        }
    }

}
