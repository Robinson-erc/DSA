package tree;

public class Variable extends Expr {
    char name;
    public Variable(char c) {
       c=this.name;
    }

    @Override
    public int eval() {
        throw new IllegalArgumentException("Variable" +name+ "has no assigned value");
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Constant)) return false;
        Variable other = (Variable) obj;
        return this.name == other.name;
    }

    @Override
    public Expr simplify() {
        return this;
    }
}
