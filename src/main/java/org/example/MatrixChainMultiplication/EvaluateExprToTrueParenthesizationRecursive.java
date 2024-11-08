package org.example.MatrixChainMultiplication;

import java.util.Arrays;

public class EvaluateExprToTrueParenthesizationRecursive {

    public static int mcmRecursive(String[] arr, int i, int j, boolean isTrue) {

        // Base case: when i and j are the same, we are evaluating a single symbol
        if (i == j) {
            if (isTrue)
                return arr[i].equals("T") ? 1 : 0;
            else
                return arr[i].equals("F") ? 1 : 0;
        }

        int ways = 0;

        // k is incremented by 2 to move across operators
        for (int k = i + 1; k < j; k += 2) {
            int LT = mcmRecursive(arr, i, k - 1, true);
            int LF = mcmRecursive(arr, i, k - 1, false);
            int RT = mcmRecursive(arr, k + 1, j, true);
            int RF = mcmRecursive(arr, k + 1, j, false);

            // Calculate the number of ways for current operator based on isTrue
            String op = arr[k]; // arr[k] is the operator at position k

            if (op.equals("&")) {
                if (isTrue) {
                    ways += (LT * RT);
                } else {
                    ways += (LT * RF) + (LF * RT) + (LF * RF);
                }
            } else if (op.equals("|")) {
                if (isTrue) {
                    ways += (LT * RT) + (LT * RF) + (LF * RT);
                } else {
                    ways += (LF * RF);
                }
            } else if (op.equals("^")) {
                if (isTrue) {
                    ways += (LT * RF) + (LF * RT);
                } else {
                    ways += (LT * RT) + (LF * RF);
                }
            }
        }
        return ways;
    }

    public static void main(String[] args) {

        String[] symbol = {"T", "F", "T"};
        String[] operator = {"^", "&"};
        String[] inputArray = new String[symbol.length + operator.length];

        // Combine the symbols and operators into a single input array
        for (int x = 0; x < symbol.length; x++) {
            inputArray[2 * x] = symbol[x];  // Place the symbol at even indices
            if (x < operator.length) {
                inputArray[2 * x + 1] = operator[x];  // Place the operator at odd indices
            }
        }

        System.out.println("The given array: " + Arrays.toString(inputArray));

        // Adjusting the indices to match 0-based indexing
        int ways = mcmRecursive(inputArray, 0, inputArray.length - 1, true);
        System.out.println("No. of ways for True: " + ways);

        /*--------------------------------------------------------------------------------------*/
        symbol = new String[]{"T", "F", "F"};
        operator = new String[]{"^", "&"};
        inputArray = new String[symbol.length + operator.length];

        // Combine the symbols and operators into a single input array
        for (int x = 0; x < symbol.length; x++) {
            inputArray[2 * x] = symbol[x];  // Place the symbol at even indices
            if (x < operator.length) {
                inputArray[2 * x + 1] = operator[x];  // Place the operator at odd indices
            }
        }

        System.out.println("The given array: " + Arrays.toString(inputArray));

        // Adjusting the indices to match 0-based indexing
        ways = mcmRecursive(inputArray, 0, inputArray.length - 1, true);
        System.out.println("No. of ways for True: " + ways);

        /*--------------------------------------------------------------------------------------*/

        symbol = new String[]{"T", "T", "F", "T"};
        operator = new String[]{"|", "&", "^"};
        inputArray = new String[symbol.length + operator.length];

        // Combine the symbols and operators into a single input array
        for (int x = 0; x < symbol.length; x++) {
            inputArray[2 * x] = symbol[x];  // Place the symbol at even indices
            if (x < operator.length) {
                inputArray[2 * x + 1] = operator[x];  // Place the operator at odd indices
            }
        }

        System.out.println("The given array: " + Arrays.toString(inputArray));

        // Adjusting the indices to match 0-based indexing
        ways = mcmRecursive(inputArray, 0, inputArray.length - 1, true);
        System.out.println("No. of ways for True: " + ways);
    }
}


/*
Boolean Parenthesization Problem | DP-37
Given a boolean expression with the following symbols.
Symbols
    'T' ---> true
    'F' ---> false

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
Let the input be in form of two arrays one contains the symbols (T and F) in order and the other contains operators (&, | and ^}
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
and (T|((T&F)^T)).

The given array: [T, ^, F, &, T]
No. of ways for True: 2
The given array: [T, ^, F, &, F]
No. of ways for True: 1
The given array: [T, |, T, &, F, ^, T]
No. of ways for True: 4
 */