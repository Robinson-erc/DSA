package treeDriver;
import tree.*;
public class TestQuizExpr {
    //Expr e1= new Difference(new Difference(new Variable('x'),new Variable('y'),new Sum(new Variable('y'),new Variable('x'))));
    public static void main(String args[]) {
        Expr x = new Variable('x');
        Expr y = new Variable('y');

        Expr expr1 = new Difference(x,y);
        Expr expr2 = new Sum(y,x);

        Expr originalExpr = new Difference(expr1,expr2);

        Expr expectedExpr = new Difference(new Difference(new Constant(0),y),y);



        System.out.println("Original Expression: "+originalExpr);
        System.out.println("expected simplified expression: "+expectedExpr);
        System.out.println("simplified expression: "+originalExpr.simplify());



    }
}
