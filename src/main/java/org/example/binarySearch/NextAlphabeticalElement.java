package org.example.binarySearch;

public class NextAlphabeticalElement {

    public static char getFloorElementIndex(char[] arr,char target)
    {
        int left = 0;
        int right = arr.length - 1;
        char ceiling=' ';
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            if ((int) arr[mid] ==(int) target ) {
                System.out.println("mid: arr[mid] ==target " + mid);
                left=mid+1;
            }

            if ((int) arr[mid]>(int) target ) {
                ceiling=arr[mid];
                right = mid - 1;
            } else if ((int) arr[mid]< (int) target){
                left = mid + 1;
            }
            System.out.println("left "+left+" right "+right);
        }
        return ceiling;
    }

    public static void main(String[] args) {
        char[] arr ={'a','b','c','d','e'};
        char target='c';

        System.out.println("The index of the given element " +getFloorElementIndex(arr,target));

    }
}
