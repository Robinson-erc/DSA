package tree;



public class Quotient extends Expr {
    public Quotient(Expr left, Expr right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public int eval() {
        return left.eval() / right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quotient)) return false;
        Quotient other = (Quotient) obj;
        return this.left.equals(other.left) && this.right.equals(other.right);
    }

    @Override
    public Expr simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Constant && right instanceof Constant) {
            if (right.eval() != 0) {
                return new Constant(eval());
            } else {
                System.err.println("Cannot have zero as the right operand!");
                return null;
            }
        }
        if (left.eval() == right.eval()) {
            return new Constant(1);
        }
        return this;
    }



    @Override
    public String toString() {
        return "(" + left + "/" + right + ")";
    }

}
