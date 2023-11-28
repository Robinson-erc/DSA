package set;

import list.Iterator;
import tree.BinaryTree;
import tree.EmptyBinarySearchTree;

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
        return false;
    }

    @Override
    public void clear() {
        for (int i =0; i < tree.size(); i++){
            tree = tree.remove(i);
        }
    }
}
