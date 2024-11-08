package org.example.dynamicProgramming;

// Coin Change – Minimum Coins to Make Sum
/*
Incorrect Recursive Condition: The problem is to minimize the number of coins, but your recursive condition is returning 1 when the sum is 0,
which is meant for a "count subsets" type of problem. Instead, it should return 0 when the sum is 0,
because no coins are needed when the sum is already 0.

Inappropriate Base Condition: When n == 0 and the sum is not 0,
it should return Integer.MAX_VALUE (or a large number) to indicate that it's impossible to make the sum with 0 coins.
 */
public class CoinMinChangeRecursion {

    public static int countOfSubsetSumMatches(int[] arr, int sum, int n) {
        // Base condition
        if (sum == 0) {
            return 0; // No coins needed to make sum 0
        }
        if (n == 0) {
            return Integer.MAX_VALUE - 1; // If no coins left and sum is not 0, return a large value
        }

        if (arr[n - 1] <= sum) {
            return Math.min(
                    countOfSubsetSumMatches(arr, sum, n - 1), // Exclude the coin
                    1 + countOfSubsetSumMatches(arr, sum - arr[n - 1], n) // Include the coin
            );
        } else {
            return countOfSubsetSumMatches(arr, sum, n - 1); // Exclude the coin
        }
    }

    public static void main(String[] args) {
        int[] coins = {25,10,5};
        int sum = 30;
        int n = coins.length;

        int result = countOfSubsetSumMatches(coins, sum, n);

        // If result is still a large value, that means it's not possible to make the sum
        if (result >= Integer.MAX_VALUE - 1) {
            System.out.println("Not possible to make the sum with the given coins");
        } else {
            System.out.println("Minimum coins required: " + result);
        }
    }
}
