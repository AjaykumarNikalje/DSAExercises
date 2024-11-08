package org.example.MatrixChainMultiplication;

public class EggDroppingProblemBottomUp {

    public static int solve(int floors, int eggs) {
        // Create a memoization table
        Integer[][] memo = new Integer[eggs + 1][floors + 1];
        return solveHelper(floors, eggs, memo);
    }

    private static int solveHelper(int floors, int eggs, Integer[][] memo) {
        // Base cases
        if (eggs == 0) {
            return 0; // No eggs means no attempts
        }
        if (eggs == 1) {
            return floors; // Only one egg, need to try all floors
        }
        if (floors == 0 || floors == 1) {
            return floors; // No floors need 0 attempts, 1 floor needs 1 attempt
        }

        // Check if already computed
        if (memo[eggs][floors] != null) {
            return memo[eggs][floors];
        }

        int minAttempts = Integer.MAX_VALUE;

        // Try dropping from each floor
        for (int k = 1; k <= floors; k++) {
            // Calculate attempts for the current drop
            int attempts = 1 + Math.max(solveHelper(k - 1, eggs - 1, memo),
                    solveHelper(floors - k, eggs, memo));
            // Update the minimum attempts
            minAttempts = Math.min(minAttempts, attempts);
        }

        // Store the computed value in the memoization table
        memo[eggs][floors] = minAttempts;
        return minAttempts;
    }

    public static void main(String[] args) {
        int floors = 4;
        int eggs = 2;

        System.out.println("The minimum number of attempts to find the highest floor: " + solve(floors, eggs));
    }
}
