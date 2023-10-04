package list;

/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<E> implements List<E>
{

    int size;
    Node<E> head=new Node<E>(null,null,null);
    Node<E> tail=new Node<E>(null,null,head);
    private Node<E> ref;

    public LinkedList()
    {
        head.next=tail;
    }   

    public E get(int ndx)
    {
        setRef(ndx);
        return ref.value;

    }

    private void setRef(int ndx)
    {
       if(ndx<0 || ndx>size){
           throw new IndexOutOfBoundsException("index is out of bounds "+ndx);
           
       }
       if(ndx<=size/2){
           //starting from head moving forward
           ref=head.next;
           for(int i=0;i<ndx;i++){
               ref=ref.next;
           }
       
        }
        else{
            ref=tail.prev;
            for(int i=size-1; i>ndx;i--){
                ref=ref.prev;
            }
        }
    }

    public E set (int ndx, E value)
    {
        setRef(ndx);
        E result=ref.value;
        ref.value=value;
        return result;
    }

    public void add(E value)
    {
        Node <E> temp = new Node<E>(value,tail,tail.prev);
        tail.prev.next=temp;
        tail.prev=temp;
        size++;
    }

    public void add(int ndx, E value)
    {
        setRef(ndx);
        Node temp = new Node<E>(value,ref,ref.prev);
        ref.prev.next=temp;
        ref.prev=temp;
        size++;
    }

    public E remove(int ndx)
    {
        setRef(ndx);
        ref.prev.next=ref.next;
        ref.next.prev=ref.prev;
        size--;
        return ref.value;
    }

    public int indexOf(Object obj){
        int index = 0;
        ref = head.next;
        for(int i=0; i < size; i++){
            if(ref.value.equals(obj)){
                return  i;
            }
            else{
                ref= ref.next;
            }
        }
        return -1; // Object not found in the list
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    public void clear() {
        // Remove all elements from the linked list
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator(){
        return new RefIterator<E>(this);

    }

    public String toString()
    {
        if(isEmpty())
        {
            return"[]";
        }
        Iterator<E> it= this.iterator();
        String result=it.next().toString();
        while(it.hasNext()){
            result= result +" , "+ it.next();
        }
        return "["+result+"]";

    }

    public boolean firstIsDuplicated(){
        //under construction
        return true;
    }

    public boolean remove(Object obj){
        Iterator<E> iterator = iterator();

        while(iterator.hasNext()){
            E temp= iterator.next();
            if(temp.equals(obj)){
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj==(null) || !(obj instanceof List<?>)){
            return false;
        }

        List<?> otherList = (List<?>) obj;

        if (size() !=otherList.size())
        {
            return false;
        }
        Iterator<E> thisIterator =iterator();
        Iterator<?> otherIterator= otherList.iterator();

        while(thisIterator.hasNext() && otherIterator.hasNext()){
            E thisElement = thisIterator.next();
            Object otherElement= otherIterator.next();
            if(!thisElement.equals(otherElement)){
                return false;
            }

        }

        return true;
    }

    public ListIterator<E> listIterator(){
        return new RefListIterator<E> (this);
    }

    public ListIterator<E> listIterator(int start){
        return new RefListIterator<E>(this,start);
    }

}
