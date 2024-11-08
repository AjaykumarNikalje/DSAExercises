package org.example;

public class TrappingRainWaterPract {

    public static int trap(int[] heights){
        int iL=0,jR=heights.length-1;
        int sum=0;
        int leftMax=heights[iL],rigtMax=heights[jR];

        while (iL<jR){

            if (leftMax<rigtMax)
            {
                sum+= leftMax-heights[iL];
                iL++;
                leftMax=Math.max(leftMax,heights[iL]);
            }
            else
            {
                sum+= rigtMax-heights[iL];
                jR--;
                rigtMax=Math.max(rigtMax,heights[jR]);
            }
        }

    return sum;
    }

    public static void main(String[] args)
    {
        int[] heights=new int[]{4, 2, 0, 3, 2, 5};
        System.out.print(trap(heights));
    }
}
