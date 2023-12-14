package set;

import list.Iterator;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;
import tree.TreeIterator;

/**
 * A set implemented with a BinaryTree
 * the values are in their natural order
 * @author sdb & Eric Robinson
 */
public class TreeSet<E extends Comparable> implements Set<E> {
    BinaryTree<E> tree = new EmptyBinarySearchTree<>();
    @Override
    public boolean add(E value) {
        if (contains(value)) return false;
        tree = tree.add(value);
        return true;
    }

    @Override
    public boolean contains(Object obj) {
        return tree.containsKey(obj);
    }

    @Override
    public boolean remove(Object obj) {
        if (!contains(obj)) return false;
        tree = tree.remove(obj);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return tree.iterator();
    }
    public int size(){
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree = new EmptyBinarySearchTree<>();
    }

    @Override
    public Set<E> union(Set<E> other) {
        TreeSet<E> set = new TreeSet<>();
        Iterator<E> it = iterator();
        while (it.hasNext()){
            set.add(it.next());
        }
        it = other.iterator();
        while (it.hasNext()){
            set.add(it.next());
        }
        return set;
    }

    public boolean equals(Object obj){
        if(! (obj instanceof Set)) return false;
        if(this == obj) return true;
        Iterator<E> it = iterator();
        if (obj instanceof Set) {

            Set<E> other = (Set<E>) obj;
            if (this.size() != other.size()) return false;
            while (it.hasNext()) {
                if (!other.contains(it.next())) return false;
            }
            return true;
        }
        while (it.hasNext()) {
            if (!obj.equals(it.next())) return false;
        }
        return true;
    }
    public String toString(){
        return tree.toString();
    }
}
