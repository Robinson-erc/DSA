package tree;
import list.*;
/**
 * An EBST has no value, nor children
 */
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E>
{

    @Override
    public E getValue() {
        return null;
    }

    @Override
    public E get(E value) {
        return null;
    }

    @Override
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override
    public BinaryTree<E> remove(Object obj) {
        return this;
    }

    @Override
    public BinaryTree<E> add(E value) {
        BinarySearchTree.added = true;
        return new BinarySearchTree<E>(value);
    }

    @Override
    public void setLeft(BinaryTree<E> left) {
        //should never be called
    }

    @Override
    public BinaryTree<E> getLeft() {
        return null;
    }

    @Override
    public BinaryTree<E> getRight() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setRight(BinaryTree<E> right) {
        //should never be called;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void setValue(E value) {

    }
}
