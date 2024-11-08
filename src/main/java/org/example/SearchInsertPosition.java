package org.example;

public class SearchInsertPosition {

    private static int getIndex(int numArray[], int number_to_search_for) {
        int low = 0;
        int high = numArray.length - 1;

        while (low <= high){
            int middleIndex = (low + high) / 2;
            int middleIndexNumber = numArray[middleIndex];

            if (number_to_search_for == middleIndexNumber){
                return middleIndex;
            }
            if (number_to_search_for < middleIndexNumber){
                high = middleIndex - 1;
            }
            if (number_to_search_for > middleIndexNumber){
                low = middleIndex + 1;
            }
        }

        return low;
    }
    public static void main(String[] args){
        int[] arr={1,3,5,6,9};
        int target=7;

        System.out.print(getIndex(arr,target));
    }
}