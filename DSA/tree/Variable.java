package tree;

public class Variable extends Expr {
    char symbol;
    Integer value;
    public Variable(char symbol) {
        this.symbol = symbol;
    }
    public int eval() {
        if(value == null) {
            throw new IllegalArgumentException();
        }
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public boolean equals(Object obj) {
        if(!(obj instanceof Variable)) {
            return false;
        }
        Variable other = (Variable)obj;
        return symbol == other.symbol;
    }
    public Expr simplify() {
        return this;
    }
    public String toString() {
        return symbol + "";//((Character)symbol).toString()
    }
}