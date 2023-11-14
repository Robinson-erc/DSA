package tree;

public class Assign extends Expr {
    public Assign(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }
    public int eval() {
        if(!(left instanceof Variable))
        {
            throw new IllegalArgumentException();
        }
        ((Variable)left).setValue(right.eval());
        return right.eval();
    }
    public boolean equals(Object obj) {
        if(!(obj instanceof Assign))
        {
            return(false);
        }
        Assign other = (Assign)obj;
        return right.equals(other.right);
    }
    public Expr simplify() {
        left=left.simplify();
        right=right.simplify();
        return this;
    }
    public String toString() {
        return "(" + left + " = " + right + ")";
    }
}