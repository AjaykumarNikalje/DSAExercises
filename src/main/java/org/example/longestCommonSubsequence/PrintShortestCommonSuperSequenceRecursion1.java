package org.example.longestCommonSubsequence;

public class PrintShortestCommonSuperSequenceRecursion1 {

    public static String shortestCommonSupersequence(String input1, String input2, int ip1Len, int ip2Len) {
        // base condition
        if (ip1Len < 0 && ip2Len < 0) {
            return "";
        }
        if (ip1Len < 0) {
            return input2.substring(0, ip2Len + 1);
        }
        if (ip2Len < 0) {
            return input1.substring(0, ip1Len + 1);
        }

        // If characters match, include the character in the supersequence
        if (input1.charAt(ip1Len) == input2.charAt(ip2Len)) {
            return shortestCommonSupersequence(input1, input2, ip1Len - 1, ip2Len - 1) + input1.charAt(ip1Len);
        } else {
            // If characters don't match, include one character and continue the recursion
            String str1 = shortestCommonSupersequence(input1, input2, ip1Len - 1, ip2Len) + input1.charAt(ip1Len);
            String str2 = shortestCommonSupersequence(input1, input2, ip1Len, ip2Len - 1) + input2.charAt(ip2Len);

            // Return the shorter result
            return (str1.length() < str2.length()) ? str1 : str2;
        }
    }

    public static void main(String[] args) {
        String input1 = "AGGTAB";
        String input2 = "AGGTAB";
        // Output: AGGXTXAYB
        String output = shortestCommonSupersequence(input1, input2, input1.length() - 1, input2.length() - 1);
        System.out.println("Shortest Common Super Sequence : " + output);
    }
}
