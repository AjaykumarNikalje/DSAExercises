package org.example.binarySearch;

public class SearchingInNearlySortedArray {

    public static int getElementIndex(int[] arr,int target)
    {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            if (arr[mid] ==target ) {
                System.out.println("The number of rotations: " + mid);
                return mid;
            }
            else if(mid>left && target==arr[mid-1])
            {
                return mid-1;
            }
            else if(mid<right && target==arr[mid+1])
            {
                return mid+1;
            }

            // If the left half is sorted and right array is not.
            if (target>arr[mid] ) {
                left = mid + 1;
            } else if ( target<arr[mid]){
                // Right half is sorted and left array is not
                right = mid - 1;
            }
            else {
                // both array is sorted
                right = mid - 1;
            }
            System.out.println("left "+left+" right "+right);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr ={10, 3, 40, 20, 50, 80, 70};
        int target=40;

        System.out.println("The index of the given element " +getElementIndex(arr,target));

    }
}
