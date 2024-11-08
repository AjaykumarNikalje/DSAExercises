
package org.example.slidingWindow;

public class VariableWindowSizeLargestSubarrayOfSumK {

    public static void main(String[] args)
    {
    int[] arr = { 10, 5, 2, 7, 1, 9 };
    int k = 15;

    int i=0;
    int j=0;
    int sum=0;
    int max= Integer.MIN_VALUE;
    while(j<arr.length)
    {
        sum=sum+arr[j];

        if(sum < k)
        {
            j++;
        }
        else if(sum==k)
        {
            max=Math.max((j-i+1),max);
            j++;
        }
        else if(sum>k && i<j)
        {
            while(sum>k)
            {
                sum=sum-arr[i];
                i++;
            }
            j++;
        }

    }
    System.out.println("Largest window size with sum "+k+" "+max);
    }
}
