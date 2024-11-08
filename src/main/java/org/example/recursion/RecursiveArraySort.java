package org.example.recursion;

import java.util.Arrays;

public class RecursiveArraySort {

        // Function to insert the element in its correct position in the sorted portion
        public static void insertRecursively(int[] arr, int n, int last) {
            // Base case: If we have checked all elements or found the correct position
            if (n == 0 || arr[n - 1] <= last) {
                arr[n] = last;
                return;
            }

            // Shift the element to the right
            arr[n] = arr[n - 1];

            System.out.println("insertRecursively The last value is "+ last);
            System.out.println("insertRecursively arr[n-1] "+ arr[n-1]);
            System.out.println("insertRecursively n "+ n);

            // Recursively call to check the next element
            insertRecursively(arr, n - 1, last);
        }

        // Function to recursively sort the array
        public static void recursiveSort(int[] arr, int n) {
            // Base case: If the array has only one element, it's already sorted
            if (n < 1) {
                System.out.println("recursiveSort: This is base case "+ n);
                return;
            }

            // Sort the first n-1 elements
            recursiveSort(arr, n - 1);

            // Insert the nth element at the correct position
            int last = arr[n - 1];
            System.out.println(" ----------------------- ");
            System.out.println(" The last value is "+ last);
            System.out.println(" arr[n-1] "+ arr[n-1]);
            System.out.println(" n "+ n);


            insertRecursively(arr, n - 1, last);
            System.out.println(Arrays.toString(arr));
            System.out.println(" ----------------------- ");
        }

        public static void main(String[] args) {
            int[] arr = {3, 1, 4, 2, 5};

            // Sorting the array using recursion
            recursiveSort(arr, arr.length);

            // Print the sorted array
            System.out.println(Arrays.toString(arr));
        }
    }
