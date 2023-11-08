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
        if (left instanceof Constant && left.eval() == 0) return new Constant(0);
        if (right instanceof Constant && right.eval() == 0) {
            System.err.println("No division by zero!");
            return null;
        }
        if (left.eval()==right.eval()){
            return new Constant(1);
        }
        return this;
    }


    @Override
    public String toString() {
        return "(" + left + "/" + right + ")";
    }

}
