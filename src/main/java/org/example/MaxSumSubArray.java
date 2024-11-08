/*
This problem is solved using Largest Sum Contiguous Subarray (Kadane’s Algorithm)
*/

package org.example;

public class MaxSumSubArray {
    public static void main(String[] args) {

        int max_sum=0,cur_sum=0;
        int [] arr= new int[] {-2,-3,4,-1,-2,1,5,-3};

        for(int i=0;i< (arr.length-1) ;i++)
        {
                cur_sum=cur_sum+arr[i];

                if(cur_sum<0)
                {
                    cur_sum=0;
                }

                if(cur_sum>max_sum)
                {
                    max_sum=cur_sum;
                }
        }
        System.out.println("The Maximum sum of subarray: "+max_sum);
    }
}