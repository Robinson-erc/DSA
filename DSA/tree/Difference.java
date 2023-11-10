package tree;

public class Difference extends Expr {
    public Difference(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() - right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Difference)) return false;
        Difference other = (Difference) obj;
        return this.left.equals(other.left) && this.right.equals(other.right);
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && left.equals(new Constant(0))) return right;
        if (right instanceof Constant && right.equals(new Constant(0))) return left;
        if (left.equals(right)) return  new Constant(0);
        return this;
    }


    @Override
    public String toString() {
        return "(" + left + "-" + right + ")";
    }

}
