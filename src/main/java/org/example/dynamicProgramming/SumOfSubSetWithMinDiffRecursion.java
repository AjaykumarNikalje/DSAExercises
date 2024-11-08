package org.example.dynamicProgramming;

import java.util.Arrays;

public class SumOfSubSetWithMinDiffRecursion {

    // Helper function for pure recursive calculation
    public static int findMinDiff(int[] arr, int n, int sum1, int total_sum) {
        // Base case: no more elements to consider
        if (n == 0) {
            // Return the difference between two subsets
            int sum2 = total_sum - sum1;
            return Math.abs(sum2 - sum1);
        }

        // Recursive calls:
        // Case 1: Include current element in subset 1
        int include = findMinDiff(arr, n - 1, sum1 + arr[n - 1], total_sum);

        // Case 2: Exclude current element from subset 1
        int exclude = findMinDiff(arr, n - 1, sum1, total_sum);

        // Return the minimum of the two cases
        return Math.min(include, exclude);
    }

    // Wrapper function
    public static int getMinimumSubsetDiff(int[] arr) {
        int total_sum = Arrays.stream(arr).sum();
        int n = arr.length;

        // Start the recursion with sum1 = 0 and total_sum calculated from array
        return findMinDiff(arr, n, 0, total_sum);
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};

        // Find the minimum subset sum difference
        int minDiff = getMinimumSubsetDiff(arr);

        System.out.println("The minimum difference between two subsets: " + minDiff);
    }
}
