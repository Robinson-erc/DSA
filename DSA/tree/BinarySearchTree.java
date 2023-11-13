package tree;
import list.*;

/**
 * A BinaryTree in which the value is
 * strictly smaller than all values in
 * the right child's family and strictly
 * larger than the left child's family.
 * Both children are either empty or binary search trees.
 *
 * @author Eric robinson
 * @version
 */
public class BinarySearchTree<E extends Comparable> implements BinaryTree<E>
{
    E value;
    BinaryTree<E> left = new EmptyBinarySearchTree<E>();
    BinaryTree<E> right = new EmptyBinarySearchTree<E>();
    int size = 1;
    static boolean added, removed;


    public BinarySearchTree(E value)
    {
        this.value = value;
    }

    public E getValue()
    {
        return this.value;
    }

    public E get(E value)
    {
        int cmp = this.value.compareTo(value);
        if ( cmp == 0 )
        {
            return this.value;
        }

        if ( cmp < 0 )
        {
            return right.get(value);
        }

        else
        {
            return left.get(value);
        }
    }

    public boolean containsKey(Object obj)
    {
        try
        {
            E key = (E) obj;
            int cmp = this.value.compareTo(key);

            if ( cmp == 0 )
            {
                return true;
            }

            if ( cmp < 0 )
            {
                return right.containsKey(key);
            }
            else
            {
                return left.containsKey(key);
            }
        }
        catch ( Exception cce)
        {
            return false;
        }
    }

    public void setLeft(BinaryTree<E> left)
    {
        this.left = left;
        size = left.size() + right.size() + 1;
    }

    public void setRight(BinaryTree<E> right)
    {
        this.right = right;
        size = left.size() + right.size() + 1;
    }

    public BinaryTree<E> add(E value)
    {
        added = false;
        return addHelper(value);
    }

    private BinaryTree<E> addHelper(E value)
    {
        int cmp = this.value.compareTo(value);

        if ( cmp < 0 )
        {
            right = right.add(value);
        }

        if ( cmp > 0 )
        {
            left = left.add(value);
        }

        if ( added ) size++;

        return this;
    }

    public BinaryTree<E> getLeft()
    {
        return left;
    }

    public BinaryTree<E> getRight()
    {
        return right;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public void setValue(E value)
    {
        this.value = value;
    }

    public BinaryTree<E> remove(Object obj)
    {
        removed = false;
        try
        {
            E key = (E)obj;
            return removeHelper(key);
        }
        catch ( Exception cce )
        {
            return this;
        }
    }

    private BinaryTree<E> removeHelper(E key)
    {
        int cmp = this.value.compareTo(key);
        if ( cmp == 0 )
        {
            removed = true;
            List<BinaryTree<E>> kids = children();
            if ( kids.isEmpty() )
            {
                return new EmptyBinarySearchTree<E>();
            }
            if ( kids.size() == 1 )
            {
                return kids.get(0);
            }
            else
            {
                E successor = getSuccessor();
                removeHelper(successor);
                this.value = successor;
                return this;
            }
        }
        if ( cmp < 0 )
        {
            right = right.remove(key);
        }
        if ( cmp > 0 )
        {
            left = left.remove(key);
        }
        if ( removed ) size--;
        return this;
    }

    private List<BinaryTree<E>> children()
    {
        List<BinaryTree<E>> result = new ArrayList<BinaryTree<E>>();
        if ( !left.isEmpty() )
        {
            result.add(left);
        }
        if ( !right.isEmpty() )
        {
            result.add(right);
        }
        return result;
    }

    private E getSuccessor()
    {
        BinaryTree<E> result = right;
        while ( !result.getLeft().isEmpty() )
        {
            result = result.getLeft();
        }
        return result.getValue();
    }

    public Iterator<E> iterator()
    {
        return new TreeIterator<E>(this);
    }

    public String toString(){
        Iterator<E> itty = this.iterator();
        String  out = "[" + itty.next().toString();
        while(itty.hasNext()){
            out += ","+itty.next().toString();
        }
        return out + "]";
    }
}

