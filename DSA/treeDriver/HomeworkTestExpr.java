package treeDriver;
import tree.*;

/**Test the Expression tree classes.
 *
 * @author (sdb) 
 * @version (2020)
 */
public class HomeworkTestExpr 
{
  public static void main(String [] args)
  {   Expr e1 = new Sum (new Constant(3), new Constant(5));       //  3 + 5  
      System.out.println (e1 + " = " + e1.eval());                // should be 8
      Expr e2 = new Sum (new Constant(5), new Constant(3));       //  5 + 3 
      
      e1 = new Quotient (e1, e2);
      System.out.println ("The quotient is " + e1);                 // (3+5) / (5+3)
      System.out.println ("It simplifies to " + e1.simplify());       // 1
      
      e1 = new Difference (new Constant(3), new Constant(5));       //  3 - 5
      System.out.println(e1+" simplifies to "+ e1.simplify());
      e2 = new Difference (new Constant(5), new Constant (3));      //  5 - 3
      System.out.println(e2+" simplifies to "+ e2.simplify());
      if (e1.equals (e2))
        System.err.println ("Not correct: equals in Difference ");

      Expr e3 = new Mod(new Constant(10), new Constant(3)); // 10 % 3
      System.out.println("The remainder is " + e3); // (10 % 3)
      System.out.println("It simplifies to " + e3.simplify()); // 1

      Expr zero = new Constant (0);
      Expr one = new Constant (1);
      e1 = new Sum (new Constant (3), zero);        // 3 + 0
      System.out.println (e1 + " simplifies to " + e1.simplify());           // 3
      
      e1 = new Product (new Constant (4), zero);    // 4 * 0
      System.out.println (e1 + " simplifies to " + e1.simplify());            // 0
      
      e1 = new Product (e2, one);                   //  (5-3) * 1
      System.out.println (e1 + " simplifies to " + e1.simplify());            //  (5 - 3)

      Expr e4 = new Difference(new Constant(0), new Constant(5));
      System.out.println (e4 + " simplifies to " + e4.simplify());
    }
  
}
