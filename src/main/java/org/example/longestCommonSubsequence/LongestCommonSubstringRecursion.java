package org.example.longestCommonSubsequence;
public class LongestCommonSubstringRecursion {

    public static int longestCommonSubstring(String s1, String s2, int length1, int length2, int count) {
        // Base condition: if we've reached the end of either string
        if (length1 == 0 || length2 == 0) {
            return count; // Return the current count when either string is exhausted
        }

        // If characters match, increase the count
        if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
            count = longestCommonSubstring(s1, s2, length1 - 1, length2 - 1, count + 1);
        }

        // Calculate the maximum length found so far, considering both strings' characters
        int maxCount = Math.max(count, Math.max(
                longestCommonSubstring(s1, s2, length1 - 1, length2, 0),
                longestCommonSubstring(s1, s2, length1, length2 - 1, 0)
        ));

        return maxCount; // Return the maximum count found
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ACD";
        int output = longestCommonSubstring(s1, s2, s1.length(), s2.length(), 0);
        System.out.println("Longest Common Substring Length: " + output);

        s1 = "abcds1s2z";
        s2 = "s1s2zabcd";
        output = longestCommonSubstring(s1, s2, s1.length(), s2.length(), 0);
        System.out.println("Longest Common Substring Length: " + output);

        s1 = "abc";
        s2 = "";
        output = longestCommonSubstring(s1, s2, s1.length(), s2.length(), 0);
        System.out.println("Longest Common Substring Length: " + output);
    }
}
