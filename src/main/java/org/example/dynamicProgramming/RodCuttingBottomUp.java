
package org.example.dynamicProgramming;

import java.util.Arrays;

public class RodCuttingBottomUp {

    // Function to implement Bottom-Up DP approach
    public static int knapSack(int n, int w, int[] profit, int[] weight) {

        // Create a DP table to store results of subproblems
        int[][] dp = new int[n + 1][w + 1];

        // Initialize the table: dp[i][j] means max profit for first i items with capacity j
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                // Base case: No items or 0 capacity (Initialize)
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (weight[i-1] <= j) {
                    // Either include the item or exclude it
                    dp[i][j] = Math.max(
                            dp[i - 1][j],  // Exclude the item
                            profit[i - 1] + dp[i][j - weight[i - 1]] // Include the item
                    );
                } else {
                    // If the current item's weight is more than the remaining capacity, exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return the maximum profit for n items with capacity w
        return dp[n][w];
    }

    public static void main(String[] args) {

        int[] price= {1,5,8,9,10,17,17,20};
        int[] len=new int[price.length];
        int n=price.length;

        for(int i=0;i<n;i++)
        {
            len[i]=i+1;
        }
        System.out.println(Arrays.toString(len));
        System.out.println(Arrays.toString(price));
        int maxProfit = knapSack(n, n, price, len);
        System.out.println( "max price: "+maxProfit );
    }
}
