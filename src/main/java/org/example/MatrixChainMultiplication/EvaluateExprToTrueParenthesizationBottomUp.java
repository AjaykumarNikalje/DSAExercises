
package org.example.MatrixChainMultiplication;

import java.util.Arrays;

public class EvaluateExprToTrueParenthesizationBottomUp {

    // Memoization table
    public static int[][][] dp;

    public static int mcmMemo(String[] arr, int i, int j, boolean isTrue) {

        // Convert boolean isTrue to int (1 for true, 0 for false) for easier indexing
        int boolIndex = isTrue ? 1 : 0;

        // If already computed, return the stored value
        if (dp[i][j][boolIndex] != -1) {
            return dp[i][j][boolIndex];
        }

        // Base case: when i and j are the same, we are evaluating a single symbol
        if (i == j) {
            if (isTrue) {
                dp[i][j][boolIndex] = arr[i].equals("T") ? 1 : 0;
            } else {
                dp[i][j][boolIndex] = arr[i].equals("F") ? 1 : 0;
            }
            return dp[i][j][boolIndex];
        }

        int ways = 0;

        // k is incremented by 2 to move across operators
        for (int k = i + 1; k < j; k += 2) {
            int LT = mcmMemo(arr, i, k - 1, true);
            int LF = mcmMemo(arr, i, k - 1, false);
            int RT = mcmMemo(arr, k + 1, j, true);
            int RF = mcmMemo(arr, k + 1, j, false);

            // Calculate the number of ways for the current operator based on isTrue
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

        // Store the result in dp before returning
        dp[i][j][boolIndex] = ways;
        return dp[i][j][boolIndex];
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

        // Initialize memoization table with -1 (indicating uncomputed values)
        int n = inputArray.length;
        dp = new int[n][n][2]; // Third dimension is for true/false
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);  // Fill the 3D table with -1
            }
        }

        // Adjusting the indices to match 0-based indexing
        int ways = mcmMemo(inputArray, 0, inputArray.length - 1, true);
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

        // Reset memoization table for new input
        n = inputArray.length;
        dp = new int[n][n][2];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        // Adjusting the indices to match 0-based indexing
        ways = mcmMemo(inputArray, 0, inputArray.length - 1, true);
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

        // Reset memoization table for new input
        n = inputArray.length;
        dp = new int[n][n][2];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        // Adjusting the indices to match 0-based indexing
        ways = mcmMemo(inputArray, 0, inputArray.length - 1, true);
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