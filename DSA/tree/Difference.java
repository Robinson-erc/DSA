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

    /**
     * Refer to the lab on Expression Trees.  An Expr may be a Constant, Variable, Sum, Difference, Product, Quotient, Mod, or Assign, which correspond to arithmetic operations.  Each Expr has a simplify() method which is supposed to return a simplified form of the Expr (if it can be simplified).   Implement the following mathematical identity, where x and y represent any Expr:
     *
     * (x + y) - (x - y) = y + y = 2 * y
     *
     * Edit the simplify() method in one of your source files in the tree package, and upload that source file only, on Canvas.
     * @return
     */
    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Difference && right instanceof Sum){
            Difference leftDiff = (Difference) left;
            Sum rightSum = (Sum) right;

            if (leftDiff.right.equals(rightSum.right)&& leftDiff.left.equals(rightSum.left)){
                return new Difference(new Difference(new Constant(0), rightSum.left), rightSum.right);
            }
        }
        if (left instanceof Constant && left.equals(new Constant(0))) return this;
        if (right instanceof Constant && right.equals(new Constant(0))) return left;
        if (left.equals(right)) return  new Constant(0);
        //handle the case similar to (x + y) - (x - y) = y + y = 2 * y
        if (left instanceof Sum && right instanceof Difference) {
            Sum leftSum = (Sum) left;
            Difference rightDiff = (Difference) right;
            Assign leftAssign = (Assign) leftSum.left;
            Assign rightAssign = (Assign) rightDiff.right;

            if (leftAssign.equals(rightAssign)) {
                return new Sum(new Constant(2), rightDiff.left);
            }
        }
        return this;
    }


    @Override
    public String toString() {
        return "(" + left + "-" + right + ")";
    }


}
