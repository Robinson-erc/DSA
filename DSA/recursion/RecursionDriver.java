package recursion;

public class RecursionDriver {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();

        // Test the fact method
        int factorialResult = recursion.fact(5);
        System.out.println("Factorial of 5: " + factorialResult);

        // Test the fib method
        int fibonacciResult = recursion.fib(6);
        System.out.println("Fibonacci number at position 6: " + fibonacciResult);

        // Test the pal method
        String palindromeString = "tacocat";
        boolean isPalindrome = recursion.pal(palindromeString);
        System.out.println("'" + palindromeString + "' is a palindrome: " + isPalindrome);

        // Test the mult method
        int multiplicationResult = recursion.mult(4, 7);
        System.out.println("4 * 7 = " + multiplicationResult);

        // Test the power method
        int powerResult = recursion.power(2, 3);
        System.out.println("2^3 = " + powerResult);

        //testing fib again
        int fibTest = recursion.fib(33);
        System.out.println(fibTest);


    }

}
