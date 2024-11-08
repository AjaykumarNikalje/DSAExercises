package org.example.recursion;
/*
this code will be same for subsets, power sets and sub-sequence.
They may ask to handle duplicates in case of duplicate character in this case use map to handle duplicate case.
They may ask to sort in lexigraphical order then use vector and sort the same.
*/

public class Subsets {

    public static void getSubsets(String ip, String op) {
        // Base condition
        if (ip.isEmpty()) {
            System.out.println(op.trim()); // Output current subset, trim to avoid leading spaces
            return;
        }

        // Get the first character of the input
        char first = ip.charAt(0);

        // Recursively call without including the first character
        getSubsets(ip.substring(1), op);

        // Recursively call including the first character
        getSubsets(ip.substring(1), op + first);
    }

    public static void main(String[] args) {
        String input = "abc";
        getSubsets(input, ""); // Initial output is an empty string
    }
}
