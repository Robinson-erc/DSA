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

            if (right instanceof Constant && right.equals(0)){
                System.err.println("Cannot have zero as the right operand!");
            }
            if (left instanceof Constant && left.equals(new Constant(0))){
                return new Constant(0);
            }
            if(left.equals(right)) {
                return new Constant(1);
            }

        return this;
        }






    @Override
    public String toString() {
        return "(" + left + "/" + right + ")";
    }

}
