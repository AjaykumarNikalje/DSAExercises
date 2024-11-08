package org.example.slidingWindow;

public class MaximumSumSubArray {

    public static void main(String[] args){
        //int[] arr={100,200,300,400};
        //int k=2;

        int[] arr={1,4,2,10,23,3,1,0,20};
        int k=4;

        int i=0;
        int j=0;
        int max= Integer.MIN_VALUE;
        int sum=0;
        while(j<arr.length)
        {
          if(j-i+1 < k)
          {
              System.out.println( "arr[j] "+ arr[j] );
              sum=sum+arr[j];
          }
          else
          {
              if(i==0)
              {
                  System.out.println( "arr[j] "+ arr[j] );
                  sum=sum+arr[j];
                  System.out.println( "sum "+ sum );
              }
              else
              {
                  sum=sum+arr[j]- arr[i-1];
                  System.out.println( "final sum "+ sum );
              }

              max=Math.max(max,sum);
              System.out.println("max "+max);
              i++;
          }
            j++;
        }

        System.out.println("The Maximum sum sub array: "+max);
    }
}


/*
package org.example.slidingWindow;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400};
        int k = 2;

        int max = Integer.MIN_VALUE;
        int sum = 0;

        // Calculate the sum of the first 'k' elements
        for (int j = 0; j < k; j++) {
            sum += arr[j];
        }

        max = sum; // Initialize max with the first window's sum

        // Slide the window through the rest of the array
        for (int j = k; j < arr.length; j++) {
            sum += arr[j] - arr[j - k]; // Update sum to reflect the new window
            max = Math.max(max, sum); // Update max if the new sum is larger
        }

        System.out.println("The Maximum sum subarray of size " + k + " is: " + max);
    }
}
*/

