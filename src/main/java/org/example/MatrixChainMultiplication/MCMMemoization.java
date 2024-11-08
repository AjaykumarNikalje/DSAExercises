package org.example.MatrixChainMultiplication;

public class MCMMemoization {

    // Memoization table
    private static int[][] memo;

    public static int mcmRecursive(int[] arr, int i, int j) {
        // Base condition
        if (i >= j) {
            return 0;
        }

        // Check if the value is already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = mcmRecursive(arr, i, k) +
                    mcmRecursive(arr, k + 1, j) +
                    (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(min, temp);
        }

        // Store the result in the memoization table
        memo[i][j] = min;
        return min;
    }

    public static void main(String[] args) {
        int[] inputArray =  {1, 2, 3, 4, 3} ; // Example input
        int i = 1;
        int j = inputArray.length - 1;

        // Initialize the memoization table
        memo = new int[inputArray.length][inputArray.length];
        for (int x = 0; x < memo.length; x++) {
            for (int y = 0; y < memo[x].length; y++) {
                memo[x][y] = -1; // Initialize with -1 to indicate uncomputed values
            }
        }

        int result = mcmRecursive(inputArray, i, j);
        //result=30
        System.out.println("Result is here : " + result);
    }
}
