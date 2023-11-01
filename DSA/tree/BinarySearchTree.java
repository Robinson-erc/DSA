package tree;
import list.*;
/**
 * A BT whose value is smaller than all values in
 * the right child's family, and larger than all
 * values in it left child's family, and
 * each child is a  binary search tree. No duplicates
 * @param <E>
 * @author sdb & Eric Robinson
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E> {
    E value;
    public static boolean added;
    public boolean removed;
    BinaryTree<E> left = new EmptyBinarySearchTree<E>();
    BinaryTree<E> right = new EmptyBinarySearchTree<E>();
    int size = 1; //family of this BST


    public BinarySearchTree(E value) {
        this.value = value;
    }
    public int size(){
        return this.size;
    }

    @Override
    public void setValue(E value) {

    }

    @Override
    public E getvalue() {
        return value;
    }
    public BinaryTree<E> remove(Object obj)
    {
        try{
            E key = (E)obj;
            return removeHelper(key);
        }
        catch (Exception cce)
        {
            return this;
        }
    }
    private BinaryTree<E> removeHelper(E key){
        int cmp = this.value.compareTo(key);
        if ( cmp == 0)
        {
            removed=true;
            List<BinaryTree<E>> kids = children();

            if (kids.isEmpty()){
                return new EmptyBinarySearchTree<E>();
            }
            if(kids.size() == 1){
                return kids.get(0);
            }
            else {
                E successor = getSuccessor();
                removeHelper(successor);
                this.value = successor;
                return  this;
            }
        }
        if(cmp<0){
            right = right.remove(key);
        }
        if(cmp > 0){
            left = left.remove(key);
        }

        if (removed) size --;
        return this;

    }

    private E getSuccessor() {
        BinaryTree<E> result = right;
        while ( !result.getLeft().isEmpty() );{
            result=result.getLeft();
        }
        return result.getvalue();
    }

    private List<BinaryTree<E>> children(){
        List<BinaryTree<E>> childrenList = new ArrayList<>();

        if (!left.isEmpty()) {
            childrenList.add(left);
        }
        if (!right.isEmpty()) {
            childrenList.add(right);
        }

        return childrenList;
    }
    @Override
    public E get(E value) {
        int cmp = this.value.compareTo(value);
        if(cmp==0){
           return this.value;
        }
        if(cmp<0){
            return right.getvalue();
        }
        return left.getvalue();
    }

    @Override
    public boolean containsKey(Object obj) {
        try {
            E key = (E) obj;

            int cmp = this.value.compareTo(key);
            if (cmp == 0) {
                return true;
            }
            if (cmp < 0) {
                return right.containsKey(key);
            }
            return left.containsKey(key);
        } catch (ClassCastException cce){
            return false;
        }
    }


    @Override
    public BinaryTree<E> add(E value) {
         added = false;
        return addHelper(value);
    }
    private BinaryTree<E> addHelper(E value){
        int cmp =this.value.compareTo(value);
        if(cmp<0) left = left.add(value);
        if(cmp>0) right = right.add(value);
        if (added) size++;
        return this;
    }

    @Override
    public void setLeft(BinaryTree<E> left) {
        this.left=left;
        size= left.size()+right.size()+1;

    }

    @Override
    public BinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public BinaryTree<E> getRight() {
        return right;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void setRight(BinaryTree<E> right) {
        this.right=right;
        size= left.size()+right.size()+1;
    }



}
