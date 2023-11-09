package tree;

public class Product extends Expr{
    public Product(Expr left, Expr right){
        super.left=left;
        super.right=right;
    }

    @Override
    public int eval() {
        return left.eval() * right.eval();
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.left.equals(other.left) && this.right.equals(other.right) || this.left.equals(other.right)&& this.right.equals(other.left);
    }

    @Override
    public Expr simplify() {
        left=left.simplify();
        right=right.simplify();
        if (left instanceof Constant && left.equals(0)) return new Constant(0);
        if (right instanceof Constant && right.equals(0)) return new Constant(0);
        if (left instanceof Constant && left.equals(1)) return right;
        if (right instanceof Constant && right.equals(1)) return left;
        return this;

    }
    public String toString(){
        return "("+ left + "*" + right + ")" ;
    }
}
