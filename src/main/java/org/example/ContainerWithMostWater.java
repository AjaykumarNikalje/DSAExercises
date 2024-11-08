package org.example;

public class ContainerWithMostWater {

    public static int GetMaxWaterContainerArea(int[] heights){
        int maxArea=0;
        int left=0,right=heights.length-1;

        while(left<right)
        {
            int height=Math.min(heights[left],heights[right]);
            int width=right-left;
            int area=(height * width);
            maxArea=Math.max(area,maxArea);
            if(heights[left]>heights[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
    public static void main(String[] args){
        int[]  heights=new int[]{1, 5, 4, 3};

       System.out.println("The maximum container area in the given array: " +GetMaxWaterContainerArea(heights));
    }
}
