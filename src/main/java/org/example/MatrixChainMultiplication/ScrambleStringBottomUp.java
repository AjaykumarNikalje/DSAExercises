package org.example.MatrixChainMultiplication;

import java.util.HashMap;
import java.util.Map;

public class ScrambleStringBottomUp {

    // Create a memoization map to store the results of subproblems
    private static Map<String, Boolean> memo = new HashMap<>();

    public static boolean isScramble(String a, String b) {

        // Base cases
        if (a.equals(b)) {
            return true;
        }
        if (a.length() != b.length()) {
            return false;
        }
        if (a.length() <= 1) {
            return false;
        }

        // Create a unique key to store in the memo map
        String key = a + "-" + b;

        // Check if the result for this pair of strings is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = a.length();
        boolean isTrue = false;

        // Try to partition the string at every possible point
        for (int k = 1; k < n; k++) {
            // Check for two possibilities:
            // 1. Non-swapped: a[0...k] matches b[0...k] and a[k...n] matches b[k...n]
            // 2. Swapped: a[0...k] matches b[n-k...n] and a[k...n] matches b[0...n-k]
            if (
                    (isScramble(a.substring(0, k), b.substring(0, k))
                            &&
                            isScramble(a.substring(k), b.substring(k)))
                            ||
                            (isScramble(a.substring(0, k), b.substring(n - k))
                                    &&
                                    isScramble(a.substring(k), b.substring(0, n - k)))
            ) {
                isTrue = true;
                break;
            }
        }

        // Store the result in the memoization map before returning
        memo.put(key, isTrue);
        return isTrue;
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));

        a = "phqtrnilf";
        b = "ilthnqrpf";
        System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));

        a = "abcde";
        b = "caebd";
        System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));
    }
}
