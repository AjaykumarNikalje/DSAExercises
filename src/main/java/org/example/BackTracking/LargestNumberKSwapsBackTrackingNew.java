
package org.example.BackTracking;

import java.util.Arrays;

public class LargestNumberKSwapsBackTrackingNew {

    static String maxNumber = ""; // To keep track of the maximum number found

    // Swap function to swap two characters from indices idx and idx2
    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void solve(char[] arr, int cur, int k) {
        // Base case: If no swaps left or at the last position
        if (k == 0 || cur == arr.length - 1) {
            String currentNumber = String.valueOf(arr);
            if (currentNumber.compareTo(maxNumber) > 0) {
                maxNumber = currentNumber; // Update the maximum number found
            }
            return;
        }

        // Iterate through the array to perform swaps
        for (int i = cur; i < arr.length; i++) {
            swap(arr, cur, i); // Swap the current index with the i-th index

            // Recur with the next position and one less swap
            solve(arr, cur + 1, k - 1);

            swap(arr, cur, i); // Backtrack (undo the swap)
        }

        // Call solve without performing any swap
        solve(arr, cur + 1, k);
    }

    public static void main(String[] args) {
        String str = "7599";
        int k = 2;

        // Check for empty string
        if (str.length() == 0 || str == null) {
            return;
        }

        solve(str.toCharArray(), 0, k); // Function call to find the largest number
        System.out.println("Largest number after " + k + " swaps is: " + maxNumber);
    }
}
