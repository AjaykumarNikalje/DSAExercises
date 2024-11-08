package org.example.binarySearch;

public class SearchElementInBitonicArray {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            System.out.println("mid "+mid);

            if( mid <(arr.length-1) && mid>0  )
            {
                if(arr[mid]> arr[mid+1] && arr[mid]>arr[mid-1])
                {
                    return arr[mid];
                }

                if(arr[mid]<arr[mid+1])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
            else if(mid==(arr.length-1))
            {
                if( arr[mid]>arr[mid-1])
                {
                    return arr[mid];
                }
            }
            else if(mid==0)
            {
                if( arr[mid]>arr[mid+1])
                {
                    return arr[mid];
                }
            }
            System.out.println(" left "+left +" right "+right);
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,8,3,2};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element : " + peakIndex);

    }
}
