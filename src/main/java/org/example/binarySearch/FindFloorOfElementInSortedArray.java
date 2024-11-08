package org.example.binarySearch;

public class FindFloorOfElementInSortedArray {


    public static int getFloorElementIndex(int[] arr,int target)
    {
        int left = 0;
        int right = arr.length - 1;
        int floor=-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            if (arr[mid] ==target ) {
                System.out.println("mid: arr[mid] ==target " + mid);
                return mid;
            }

            if (arr[mid]>target ) {
                right = mid - 1;
            } else if (arr[mid]< target){
                floor=arr[mid];
                left = mid + 1;
            }
            System.out.println("left "+left+" right "+right);
        }
        return floor;
    }

    public static void main(String[] args) {
        int[] arr ={1, 2, 8, 10, 10, 12, 19};
        int target=5;

        System.out.println("The index of the given element " +getFloorElementIndex(arr,target));

    }
}
