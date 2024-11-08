package org.example.slidingWindow;
import java.util.LinkedList;
import java.util.Queue;
public class FirstNegetiveNumSumSubArray {
    public static void main(String[] args){
        //int[] arr={100,200,300,400};
        //int k=2;

        //int[] arr={12,-1,-7,8,-15,30,16,28};
        //int k=3;

        int[] arr={-8,2,3,-6,10};
        int k=2;
        int i=0;
        int j=0;

        Queue<Integer> que=new LinkedList<>();

        while(j<arr.length)
        {
            if(j-i+1 < k)
            {
                if(arr[j]<0)
                {
                    que.add(arr[j]);
                }
            }
            else
            {
               if(arr[j]<0)
               {
                 que.add(arr[j]);
               }
               if(i>0)
               {que.remove(arr[i-1]);}

               System.out.println("First Negative Number: " + (que.peek() == null ? 0 : que.peek()));

             i++;
            }
            j++;
        }

    }
}


/*
package org.example.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegetiveNumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        int i = 0;
        int j = 0;

        Queue<Integer> que = new LinkedList<>();

        while (j < arr.length) {
            // Add the current element if it's negative
            if (arr[j] < 0) {
                que.add(arr[j]);
            }

            // When we've hit the size of the window
            if (j - i + 1 == k) {
                // Print the first negative number for the current window
                System.out.println("First Negative Number in [" + i + ", " + j + "]: " + (que.isEmpty() ? 0 : que.peek()));

                // Remove the element going out of the window
                if (arr[i] < 0) {
                    que.remove(arr[i]);
                }
                i++; // Move the window
            }
            j++; // Expand the window
        }
    }
}

 */