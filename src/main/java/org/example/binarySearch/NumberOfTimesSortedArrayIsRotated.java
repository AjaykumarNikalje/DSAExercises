package org.example.binarySearch;

public class NumberOfTimesSortedArrayIsRotated {

    public static void main(String[] args) {
        int[] arr ={7, 9, 11, 12, 15};
        int n=arr.length;
        int left = 0;
        int right = arr.length - 1;

        int i=0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            // Check if mid is the minimum element
            System.out.println(" Previous Element index "+(mid - 1 + n) % n +" next element index "+ (mid + 1) % n);
            if (arr[mid] < arr[(mid - 1 + n) % n] && arr[mid] < arr[(mid + 1) % n]) {
                System.out.println("The number of rotations: " + mid);
                return;
            }

            // If the left half is sorted and right array is not.
            if (arr[left] <= arr[mid] && arr[mid]>=arr[right] ) {
                left = mid + 1;
            } else if (arr[right] >= arr[mid] && arr[mid]<=arr[left] ){
                // Right half is sorted and left array is not
                right = mid - 1;
            }
            else {
                // both array is sorted
                right = mid - 1;
            }
          System.out.println("left "+left+" right "+right);
            i++;

        }

        // If the array is already sorted
        System.out.println("The number of rotations: 0");
    }
}