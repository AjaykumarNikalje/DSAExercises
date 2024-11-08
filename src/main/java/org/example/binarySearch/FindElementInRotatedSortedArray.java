package org.example.binarySearch;

public class FindElementInRotatedSortedArray {

    public static int getMinElementIndex(int[] arr)
    {
        int n=arr.length;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            // Check if mid is the minimum element
            System.out.println(" Previous Element index "+(mid - 1 + n) % n +" next element index "+ (mid + 1) % n);
            if (arr[mid] < arr[(mid - 1 + n) % n] && arr[mid] < arr[(mid + 1) % n]) {
                System.out.println("The number of rotations: " + mid);
                return mid;
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
        }
        return -1;
    }

    public static int getIndexOfElement(int[] arr,int k,int left ,int right)
    {
        int n=arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            if (arr[mid] == k) {
                System.out.println("The number of rotations: " + mid);
                return mid;
            }

            // If the left half is sorted and right array is not.
            if (k>arr[mid] ) {
                left = mid + 1;
            } else if ( k<arr[mid]){
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
        int[] arr ={4,5,6,7,0,1,2};
        int target=2;
        int finalIndex=-1;
        // If the array is already sorted
        int minIndex=getMinElementIndex(arr);
        System.out.println("The index of minimum element "+minIndex);

        if(arr[minIndex]==target)
        {
            finalIndex=minIndex;
            System.out.println("The index of the given element " +finalIndex);
            return;
        }
        //Left Array
        int leftArrayIndex=getIndexOfElement(arr,target,0,minIndex-1);

        //Right Array
        int rightArrayIndex=getIndexOfElement(arr,target,minIndex+1,arr.length-1);

        if(leftArrayIndex>-1)
        {
          finalIndex=leftArrayIndex;
        }
        else {
            finalIndex=rightArrayIndex;
        }
        System.out.println("The index of the given element " +finalIndex);

    }
}
