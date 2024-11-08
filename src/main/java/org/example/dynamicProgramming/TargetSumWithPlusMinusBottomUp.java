package org.example.dynamicProgramming;

import java.util.Arrays;
/*
494. Target Sum
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target
*/

public class TargetSumWithPlusMinusBottomUp {

    public static int countOfSubsetSumMatches(int[] arr,int sum){
        int rowLen=arr.length;
        int colLen=sum;
        int [][] t=new int[rowLen+1][colLen+1];

        for(int i=0;i<=rowLen;i++)
        {
            t[i][0]=1;
        }

        for(int j=1;j<=colLen;j++)
        {
            t[0][j]=0;
        }

        for (int i=1;i<=rowLen;i++)
            for (int j=1;j<=colLen;j++)
            {
                if( arr[i-1]<=j )
                {
                    t[i][j]= ( t[i-1][j-arr[i-1]] + t[i-1][j] );
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }

        return t[rowLen][colLen];
    }

    public static void main(String[] args){

        /*
        int[] arr={5, 2, 6, 4};
        int diff=3;
        */
        int[] arr={1,1,1,1,1};
        int target=3;
        int n=arr.length;
        int totalSum= Arrays.stream(arr).sum();

    /*
    sum1-sum2=diff;
    sum1+sum2=totalSum;
    2sum1=diff+totalSum
    */
        int sum1=( (target + totalSum) / 2);
        int count = countOfSubsetSumMatches(arr, sum1);

        System.out.println("Count "+count);
    }
}

