
package org.example.MatrixChainMultiplication;

import java.util.Arrays;

public class PalendromicPartitioningRecursion {

    public static void main(String[] args) {
        String input = "nitik";

        int i = 0;
        int j = input.length() - 1;
        int count = palindromicPartition(i, j, input);
        System.out.println("Minimum number of partitions : " + count);
    }

    private static int palindromicPartition(int i, int j, String input) {


        // If the string is already a palindrome or i >= j, no partition is needed
        if (i >= j || isPalindrome(i, j, input))
            return 0;

        int minimum = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            // Calculate the total partition count
            int temp = 1 + palindromicPartition(i, k, input) + palindromicPartition(k+1, j, input);
            minimum = Math.min(temp, minimum);
        }
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
