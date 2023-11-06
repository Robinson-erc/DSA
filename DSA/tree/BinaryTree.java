package tree;

import list.Iterator;

/**
 * A BT(binary tree) has a value
 * and at most two children
 * each of which is also a binary tree
 * @author sdb & Eric Robinson
 */
public interface BinaryTree<E> {
    /**
     * @return the value of this BT
     * or null if it has no value
     */
    E getValue();
    /**
     * search the family of this BT for the given value
     * @return the value of null if not found
     */
    E get(E value);
    /**
     * @return true if and only if the
     * family of this binary tree
     * contains the given object
     */
    boolean containsKey(Object obj);
    /**
     * @Remove the given value
     * from the family of this BT
     * @return the resulting BT
     */
    BinaryTree<E> remove(Object obj);
    /**
     * Add the given value to the family of this BT
     * @return the resulting BT
     */
    BinaryTree<E> add(E value);
    /**
     * Change the left child of this BT
     */
    void setLeft(BinaryTree<E> left);

    /** @return the left child of this BinaryTree */
    BinaryTree<E> getLeft();

    /** @return the right child of this BinaryTree */
    BinaryTree<E> getRight();

    /** @return true iff this BinaryTree is empty */
    boolean isEmpty();

    /**
     * Change the right child of this BT
     */
    void setRight(BinaryTree<E> right);
    int size();

    /** Set the value of this BinaryTree to the given value */
    void setValue(E value);

    /**
     * return an iterator for this BinaryTree
     */
    Iterator<E> iterator();

}
