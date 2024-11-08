package org.example.recursion;

import java.util.ArrayList;
import java.util.List;

public class NumericSubsets {

    // Method to generate all subsets
    public static void getSubsets(int[] arr, List<Integer> op, int index) {
        // Base condition: if index reaches the length of the array, print the subset
        if (index == arr.length) {
            System.out.println(op);  // Output the current subset
            return;
        }

        // Recursively call without including the current element
        getSubsets(arr, new ArrayList<>(op), index + 1);

        // Add the current element and recursively call
        op.add(arr[index]);
        getSubsets(arr, new ArrayList<>(op), index + 1);
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3};
        getSubsets(inputArray, new ArrayList<>(), 0); // Start with an empty list and index 0
    }
}
