package org.example.MatrixChainMultiplication;

import java.util.Arrays;

public class PalendromicPartitioningBottomUpRecursion {

    public static int[][] t = new int[1001][1001];

    public static void main(String[] args) {
        String input = "nitik";

        // Fill the memoization table with -1
        for (int[] row : t)
            Arrays.fill(row, -1);

        int i = 0;
        int j = input.length() - 1;
        int count = palindromicPartition(i, j, input);
        System.out.println("Minimum number of partitions : " + count);
    }

    private static int palindromicPartition(int i, int j, String input) {

        // If already calculated, return from memo table
        if (t[i][j] != -1)
            return t[i][j];

        // If the string is already a palindrome or i >= j, no partition is needed
        if (i >= j || isPalindrome(i, j, input))
            return 0;

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int input1;
            int input2;

            // Memoize the left partition
            if (t[i][k] != -1) {
                input1 = t[i][k];
            } else {
                input1 = palindromicPartition(i, k, input);
                t[i][k] = input1;
            }

            // Memoize the right partition
            if (t[k+1][j] != -1) {
                input2 = t[k+1][j];
            } else {
                input2 = palindromicPartition(k+1, j, input);
                t[k+1][j] = input2;
            }

            // Calculate the total partition count
            int temp = 1 + input1 + input2;
            minimum = Math.min(temp, minimum);
        }

        // Store the result in the memoization table
        t[i][j] = minimum;
        return minimum;
    }

    // Helper function to check if substring input[i..j] is a palindrome
    private static boolean isPalindrome(int i, int j, String input) {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
