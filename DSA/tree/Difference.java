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
        if (left instanceof Constant && left.eval() == 0) return new Constant(-right.eval());
        if (right instanceof Constant && right.eval() == 0) return left;
        return this;
    }


    @Override
    public String toString() {
        return "(" + left + "-" + right + ")";
    }

}
