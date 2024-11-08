package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NDigitNumbersIncreasingOrder {

    // Function to generate N-digit numbers with digits in increasing order
    public static void generateNumbers(int n, int currentLength, int lastDigit, String currentNum, List<String> result) {
        // Base case: if the current number length reaches N, add it to the result list
        if (currentLength == n) {
            result.add(currentNum);
            return;
        }

        // Try all digits from lastDigit+1 to 9 to ensure increasing order
        for (int i = lastDigit + 1; i <= 9; i++) {
            // Append current digit and recurse for the next digit
            generateNumbers(n, currentLength + 1, i, currentNum + i, result);
        }
    }

    public static List<String> generateNDigitNumbers(int n) {
        List<String> result = new ArrayList<>();
        if (n == 1) {
            // For n = 1, add digits 0 to 9 as single-digit numbers
            for (int i = 0; i <= 9; i++) {
                result.add(String.valueOf(i));
            }
        } else {
            generateNumbers(n, 0, 0, "", result); // Start with an empty number and the last digit as 0
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2; // Example: generate 1-digit numbers, you can change n to test other cases
        List<String> result = generateNDigitNumbers(n);

        // Print all generated numbers
        for (String number : result) {
            System.out.println(number);
        }
    }
}
