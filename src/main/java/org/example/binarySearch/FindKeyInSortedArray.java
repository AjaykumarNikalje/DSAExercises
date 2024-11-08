package org.example.binarySearch;

public class FindKeyInSortedArray {
        public static boolean findKey(int[] arr, int key) {
            int low = 0, high = arr.length - 1;

            // Check if the first and last elements are equal
            if (arr[low] == arr[high]) {
                return arr[low] == key;
            }

            // Determine the order of the array
            boolean isAscending = arr[high] > arr[low];

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] == key) {
                    return true;
                }

                if (isAscending) {
                    if (key < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    if (key > arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }

            return false;
        }

        public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {5, 4, 3, 2, 1};
            int key = 3;

            System.out.println(findKey(arr1, key)); // Output: true
            System.out.println(findKey(arr2, key)); // Output: true
        }
    }

