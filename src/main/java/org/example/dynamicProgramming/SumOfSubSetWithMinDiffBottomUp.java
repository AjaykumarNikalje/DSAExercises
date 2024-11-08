package org.example.dynamicProgramming;

import java.util.Arrays;

public class SumOfSubSetWithMinDiffBottomUp {

    public static boolean[][] getMinimumSubsetDiff(int[] arr)
    {
        int len=arr.length;
        int sum= Arrays.stream(arr).sum();
        int subSetSum= sum/2;

        //initialization
        boolean[][] t=new boolean[len+1][subSetSum+1];

        for(int i=0;i<=len;i++){
            t[i][0]=true;
        }

        for(int j=1;j<=subSetSum;j++){
            t[0][j]=false;
        }

        for(int i=1;i<=len;i++)
        {
            for(int j=1;j<=subSetSum;j++){

                if(arr[i-1]<=j){
                    t[i][j]= (
                              t[i-1][j]
                              ||
                              t[i-1][j-arr[i-1]]
                            );
                }
                else
                {
                    t[i][j]=t[i-1][j];
                }
            }
        }

    return t;

    }

    public static void main(String[] args){
        int[] arr={1,6,11,5};
        boolean[][] t;
        int totalSum= Arrays.stream(arr).sum();
        t=getMinimumSubsetDiff(arr);

        // Find the closest subset sum to totalSum / 2
        int closestSubsetSum = 0;
        for (int j = totalSum / 2; j >= 0; j--) {
            if (t[arr.length][j]) {
                closestSubsetSum = j;
                break;  // Once we find the largest valid subset sum <= totalSum / 2, break
            }
        }

        // The minimum difference between two subsets
        int minDiff = totalSum - 2 * closestSubsetSum;

        System.out.println("The minimum difference between two subsets: " + minDiff);


    }
}
