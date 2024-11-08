package org.example.binarySearch;

public class IndexOfFirst1InBinarySortedInfiniteArray {
    public static int binarySearch(int[] arr,int target,int left,int right)
    {
        int first =-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("The mid "+mid);

            if (arr[mid] ==target ) {
                first=mid;
                right = mid - 1;
            }

            if (arr[mid]>target ) {
                right = mid - 1;
            } else if (arr[mid]< target){
                left = mid + 1;
            }
            System.out.println("left "+left+" right "+right);
        }
        return first;
    }

    static int findPos(int arr[],int key)
    {
        int l = 0, h = 1;
        int val = arr[h];

        // Find h to do binary search
        while (val < key)
        {
            l = h;     // store previous high
            //check that 2*h doesn't exceeds array
            //length to prevent ArrayOutOfBoundException
            if(2*h < arr.length-1)
                h = 2*h;
            else
                h = arr.length-1;

            val = arr[h]; // update new val
        }

        // at this point we have updated low
        // and high indices, thus use binary
        // search between them
        System.out.println("The key found at index "+h);
        return binarySearch(arr, key,l, h );
    }

    public static void main(String[] args) {
        int[] arr ={0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        int target=1;

        System.out.println("The index of the given element " +findPos(arr,target));

    }
}
