package tree;

import list.Iterator;
import list.*;
import queue.ArrayQueue;
import queue.*;

/**
 * An iterator for BTS
 * @author sdb & Eric Robinson
 *
 */
public class TreeIterator<E> implements Iterator<E> {
    BinaryTree<E> tree;
    QueueADT<E> q = new ArrayQueue<E>();
    E lastGotten; //last value obtained by Next();
    TreeIterator(BinaryTree<E> tree){
        this.tree=tree;
        buildQ(tree);
    }

    private void buildQ(BinaryTree<E> tree){
        //in order traversal
        if(tree.isEmpty()) return;
        buildQ(tree.getLeft());
        q.add(tree.getValue());
        buildQ(tree.getRight());

    }
    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }

    @Override
    public E next() {
        lastGotten = q.remove();
        return lastGotten;
    }

    @Override
    public void remove() {
        //remove lastGotten from the tree
        if (!tree.getValue().equals(lastGotten) || tree.getLeft().isEmpty()==tree.getRight().isEmpty()){
            tree=tree.remove(lastGotten);
        }

        else{
            BinaryTree<E> child = tree.getLeft();
             if(child.isEmpty()) child=tree.getRight();
            tree.setValue(child.getValue());
            tree.setLeft(child.getLeft());
            tree.setRight(child.getRight());
        }

    }
}
