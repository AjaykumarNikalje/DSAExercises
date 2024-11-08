package org.example.recursion;

public class Factorial {

    public static int factorial(int n) {
        // Base condition: if n is 0 or 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // hypothesis
        int nMinus1=factorial(n - 1);

        // induction
        return n * nMinus1;
    }

    public static void main(String[] args) {
        int n = 5;  // You can change this value to test with other numbers
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
