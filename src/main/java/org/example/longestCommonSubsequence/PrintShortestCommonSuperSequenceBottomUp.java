package org.example.longestCommonSubsequence;

public class PrintShortestCommonSuperSequenceBottomUp {

    public static String shortestCommonSupersequence(String input1, String input2, int ip1Len, int ip2Len) {
        int LenRow = ip1Len;
        int LenCol = ip2Len;
        int[][] t = new int[ip1Len + 1][ip2Len + 1];

        // Initialize base conditions: LCS of any string with an empty string is 0
        for (int i = 0; i <= LenRow; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j <= LenCol; j++) {
            t[0][j] = 0;
        }

        // Fill the LCS table based on LCS logic
        for (int i = 1; i <= LenRow; i++) {
            for (int j = 1; j <= LenCol; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        // Now reconstruct the SCS from the LCS table
        StringBuilder scs = new StringBuilder();
        int i = ip1Len, j = ip2Len;

        while (i > 0 && j > 0) {
            // If characters match, include the character
            if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                scs.append(input1.charAt(i - 1));
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                // If they don't match, include the character from input1 and move up
                scs.append(input1.charAt(i - 1));
                i--;
            } else {
                // If they don't match, include the character from input2 and move left
                scs.append(input2.charAt(j - 1));
                j--;
            }
        }

        // If any characters are left in input1, append them
        while (i > 0) {
            scs.append(input1.charAt(i - 1));
            i--;
        }

        // If any characters are left in input2, append them
        while (j > 0) {
            scs.append(input2.charAt(j - 1));
            j--;
        }

        // Since we built the SCS in reverse, reverse the string before returning
        return scs.reverse().toString();
    }

    public static void main(String[] args) {
        String input1 = "AGGTAB";
        String input2 = "GXTXAYB";

        // Expected Output: AGGXTXAYB
        String output = shortestCommonSupersequence(input1, input2, input1.length(), input2.length());
        System.out.println("Shortest Common Supersequence: " + output);
    }
}
