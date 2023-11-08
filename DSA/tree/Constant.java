package tree;

/**
 * A constant has a value, but no operands
 */
public class Constant extends Expr{
    int value;
    public Constant(int value){
        this.value=value;
    }
    @Override
    public int eval() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Constant)) return false;
        Constant other = (Constant) obj;
        return this.value == other.value;
    }

    @Override
    public Expr simplify() {
        return this;
    }

    public String toString(){
        return value + "";
    }
}
