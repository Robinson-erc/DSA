package queue;

import list.*;


/**
 * A QueueADT, removing the value with the highest priority,
 * The value with the highest priority is the value at position 0 and the largest value
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E> {

    List<E> heap=new LinkedList<E>();

    @Override
    public void add(E value) {
        int added = heap.size();
        int parent = (added - 1) / 2;
        heap.add(value);
        while (added > 0 && greater(added, parent)) {
            swap(added, parent);
            added = parent;
            parent = (added - 1) / 2;
        }//this is now a heap
    }
    private boolean greater(int added, int parent) {
        return heap.get(added).compareTo(heap.get(parent)) > 0;
    }

    private void swap(int x, int y) {
        E temp = heap.get(x);
        heap.set(x, heap.get(y));
        heap.set(y, temp);
    }

    @Override
    public E peek() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public E remove() {
        E result = heap.get(0);
        int last = heap.size() - 1;
        int avail = 0;
        int bc = biggerChild(avail);
        while (2 * avail + 1 < last && greater(bc, last)) {
            heap.set(avail, heap.get(bc));
            avail = bc;
            bc = biggerChild(avail);
        }
        heap.set(avail, heap.get(last));
        heap.remove(last);
        return result;
    }
    public int biggerChild(int root){
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        if (left >= heap.size()) return -1;
        if (right >= heap.size()) return left;
        if (greater(left, right)) return left;
        return right;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public int size(){
        return heap.size();
    }
    @Override
    public void clear() {
        heap.clear();
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
