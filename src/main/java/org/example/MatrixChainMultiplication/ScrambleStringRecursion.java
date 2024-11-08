package org.example.MatrixChainMultiplication;

    public class ScrambleStringRecursion {

        public static boolean isScramble(String a, String b) {

            // Base cases
            if (a.equals(b)) {
                return true;
            }
            if (a.length() != b.length()) {
                return false;
            }
            if (a.length() < 1) {
                return false;
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
                )
                {
                    isTrue = true;
                    break;
                }
            }

            return isTrue;
        }

        public static void main(String[] args) {
            String a = "great";
            String b = "rgeat";

            System.out.println(a.substring(0,1) );
            System.out.println(a.substring(1) );

            System.out.println(b.substring(0,1) );
            System.out.println(b.substring(1) );

            System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));

            a = "phqtrnilf";
            b = "ilthnqrpf";
            System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));

            a = "abcde";
            b = "caebd";
            System.out.println("Is '" + b + "' a scrambled string of '" + a + "'? " + isScramble(a, b));
        }
    }


/*
Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of A = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t

To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.



Given two strings A and B of the same length, determine if B is a scrambled string of S.



Input Format:

The first argument of input contains a string A.
The second argument of input contains a string B.
Output Format:

Return an integer, 0 or 1:
    => 0 : False
    => 1 : True
Constraints:

1 <= len(A), len(B) <= 50
Examples:

Input 1:
    A = "we"
    B = "we"

Output 1:
    1

Input 2:
    A = "phqtrnilf"
    B = "ilthnqrpf"

Output 2:
    0
 */