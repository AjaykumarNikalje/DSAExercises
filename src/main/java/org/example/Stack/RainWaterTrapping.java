package org.example.Stack;

import java.util.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args)
    {
        int[] arr = {10, 9, 0, 5};
        int[] leftMax=new int[arr.length];
        int[] rightMax=new int[arr.length];

        int sum=0;
        leftMax[0]=arr[0];

        for(int i=1;i<arr.length;i++)
        {
            leftMax[i]=Math.max(arr[i],leftMax[i-1] );
        }

        rightMax[arr.length-1]=arr[arr.length-1];

        for(int i=arr.length-2;i>=0;i--)
        {
            rightMax[i]=Math.max(arr[i],rightMax[i+1] );
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        for(int i=0;i<arr.length;i++)
        {
            sum=sum+(Math.min(leftMax[i],rightMax[i]) - arr[i] );
        }

        System.out.println("The quantity of water trapped "+sum +" units.");
    }

}
