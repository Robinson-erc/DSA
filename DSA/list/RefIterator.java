package list;


/**
 * An iterator for linked lists
 *
 * @author sdb&(Eric Robinson)
 * @version (a version number or a date)
 */
public class RefIterator<E> implements Iterator<E>
{
    LinkedList<E> list;
    Node<E> cursor;
   //node storing last value
   //obtained by next()
   RefIterator(LinkedList<E>list){
       this.list=list;
       cursor=list.head;
   }
   public boolean hasNext(){
       if(cursor.next==list.tail){
           return false;
       }
       return true;
   }
   public E next(){
       cursor=cursor.next;
       return cursor.value;
   }
   public void remove(){
       cursor.prev.next=cursor.next;
       cursor.next.prev=cursor.prev;
       list.size--;
       
   }
}
