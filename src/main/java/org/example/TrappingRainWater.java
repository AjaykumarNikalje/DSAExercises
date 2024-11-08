//https://medium.com/j-t-tech/leetcode-42-trapping-rain-water-c7e6e4e3b671
package org.example;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int j=height.length-1, i=0;
        int sum=0;
        int left_max=height[i],right_max=height[j];

        while (i<j)
        {
            if(left_max < right_max)
            {
                sum+=(left_max-height[i]);
                i++;
                left_max=Math.max(left_max,height[i]);
            }
            else
            {
                sum+=(right_max-height[j]);
                j--;
                right_max=Math.max(right_max,height[j]);
            }
        }
        return sum;

    }

    public static void main(String[] args)
    {
        int[] heights=new int[]{4, 2, 0, 3, 2, 5};
        System.out.println("The total water - "+trap(heights));
    }
}