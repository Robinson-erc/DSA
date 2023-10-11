package list;

/**
 * A list implementation using an array
 *
 * @author (Eric Robinson)
 * @version (9/13/23)
 */
public class ArrayList<E> implements List<E>
{
    int size =0;
    E[] values;
    //constructors
    public ArrayList(int cap)
    {
        values= (E[]) new Object[cap];

    }

    public ArrayList(){
        this(10);
    }

    public E get(int ndx)
    {
        return values[ndx];
    }

    public E set(int ndx, E value)
    {
        E result = values[ndx];
        values[ndx]=value;
        return result;
    }

    public void add(int ndx, E value)
    {
        if(size==values.length)
            alloc(); //no room in array
        for(int i=size; i>ndx; i--)
        {
            values[i]=values[i-1];
        }
        values[ndx]=value;
        size++;

    }

    private void alloc()
    {
        E[] temp = (E[]) new Object[2 * values.length];
        for(int i=0; i<size;i++)
        {
            temp[i]=values[i];
        }
        values=temp;
    }

    public void add(E value)
    {
        add(size,value);
    }

    public E remove(int ndx) {
        E result = values[ndx];
        for (int i = ndx; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--; // Decrease the size after removing the element
        return result;
    }

    public void clear()
    {
        // Remove all elements from the list
        for (int i = 0; i < size; i++) {
            values[i] = null; // You might want to do this to release references
        }
        size = 0; // Set the size to 0 to indicate an empty list
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public int size()
    {
        return size;
    }

    public int indexOf(Object obj){
        int result=0;
        for(int i=0; i<size; i++) {
            if(obj == null){
                if(values[i]==null){
                    return i;
                }
            }
            else{
                if(obj.equals(values[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        for(int i= 0; i < size; i++){
            if(obj == null){
                if(values[i] == null){
                    return true;
                }

            } else{
                if(obj.equals(values[i])){
                    return true;
                }
            }

        }
        return false;
    }

    public String toString() {
        if (size == 0) {
            return "[]"; // Return an empty list representation
        }

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(values[i]);
            if (i < size - 1) {
                result.append(", "); // Add a comma and space for all elements except the last one
            }
        }
        result.append("]");

        return result.toString();
    }

    public Iterator<E> iterator(){
        return new ArrayIterator<E>(this);
    }

    public boolean firstIsDuplicated(){

        for(int i=0; i<size; i++){
            if(values[0] != values[i+1]){
                return false;
            }
            if(values[0] == values[i+1]){
                return true;
            }
        }

        return false;
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
        if(obj==null || !(obj instanceof List<?>)){
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
        return new ArrayListIterator<E>(this);
    }
    public ListIterator<E> listIterator(int ndx){
        return new ArrayListIterator<E>(this,ndx);
    }
    public void addAll(List<E> other){
        Iterator<E> itty = other.iterator();
        while(itty.hasNext()){
            add(itty.next());
        }
    }

}
