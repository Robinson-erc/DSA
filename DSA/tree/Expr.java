package tree;

/**
 * An Expr may have a left and right operands, each of which is  an expr. using ints.
 * @author sdb & Eric Robinson
 */
public abstract class Expr {
    Expr left,right;
    /**
     * @return the value of this Expr
     */
    public abstract  int eval();
    /**
     * @return true iff this Expr is the same as Obj
     */
    public abstract boolean equals(Object obj);

    /**
     * @returns a simplified version of this expression
     */
    public abstract Expr simplify();



}
