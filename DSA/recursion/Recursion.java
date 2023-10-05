package recursion;

public class Recursion {


    public int fact(int n)
    {
        if(n==0)
            return 1; //Basecase
        return n*fact(n-1); //recursive
    }
    /**@return the nth interger in the fibonacci sequence*/
    public int fib(int n)
    {
        if(n<2)
        {return 1;} //base case

        return fib(n-1) + fib(n-2); //recursive call
    }
    /**@return true iff given string is a palindrome*/
    public boolean pal(String s){
        if(s.length()<2)//basecase
        {return true;}
        char firstChar=s.charAt(0);
        char lastChar= s.charAt(s.length()-1);
        if(firstChar!=lastChar)//basecase
        {return false;}
        return pal(s.substring(1,s.length()-1));

    }
    /**@return the product x * y */
    public int mult(int x,int y)
    {
        if(x==0)
            {return 0;}//basecase
        return y+mult(x-1,y); //recursive call
    }
    /**
     * @return the power
     * Pre:e is not negative
     */
    public int power(int x,int e){
        if(e==0){
            return 1;
        }
        return ( x * power(x,e-1));

    }
}
