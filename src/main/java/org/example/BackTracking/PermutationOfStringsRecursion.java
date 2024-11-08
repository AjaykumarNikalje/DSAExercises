package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfStringsRecursion {

    // Function to generate all permutations of the string
    public static List<String> permute(String str) {
        // Base case: if the string is empty, return a list with an empty string
        if (str.isEmpty()) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        // Recursive case: pick the first character
        char firstChar = str.charAt(0);
        String restOfString = str.substring(1);
        System.out.println("rest of the string value is "+ restOfString);
        // Recursively get permutations of the remaining string
        List<String> permutationsOfRest = permute(restOfString);

        for (String perm : permutationsOfRest) {
            System.out.println("permutationsOfRest: "+perm);
        }
        // List to store the current permutations
        List<String> result = new ArrayList<>();

        // For each permutation of the remaining string, insert the first character
        for (String perm : permutationsOfRest) {
            for (int i = 0; i <= perm.length(); i++) {
                // Insert the first character at every possible position in the permutation
                System.out.println("i: "+i);
                System.out.println("perm.substring(0, i): "+perm.substring(0, i));
                String newPerm = perm.substring(0, i) + firstChar + perm.substring(i);
                System.out.println("newPerm: "+newPerm);
                result.add(newPerm);
            }
        }
        System.out.println(" -----------------------------  ");

        return result;
    }

    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = permute(str);

        // Print all permutations
        for (String perm : permutations) {
            System.out.println(perm);
        }
    }
}
