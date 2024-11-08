package org.example.binarySearch;

public class FirstAndLastOccurrOfElement {
    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence using binary search
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result[0] = mid;
                right = mid - 1; // Continue searching for the first occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Find the last occurrence using binary search
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result[1] = mid;
                left = mid + 1; // Continue searching for the last occurrence
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 18, 20};
        int target = 10;

        int[] result = findFirstAndLastOccurrence(arr, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}
