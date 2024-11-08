package org.example.dynamicProgramming;

import java.util.Arrays;

/*
494. Target Sum
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target
*/

//Count the number of subset with a given difference
public class TargetSumWithPlusMinusRecursion {

    public static int countOfSubsetSumMatches(int[] arr,int sum,int n)
    {
        // base condition
        if(sum==0)
        {
            return 1;
        }

        if(n==0)
        {
            return 0;
        }

        if(arr[n-1]<=sum) {
            return (

                    countOfSubsetSumMatches(arr, sum, n - 1)
                            +
                            countOfSubsetSumMatches(arr, sum-arr[n-1], n - 1)
            );
        }
        else {
            return countOfSubsetSumMatches(arr, sum, n - 1);
        }
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
        int sum1=( (target + totalSum) / 2);
        int count = countOfSubsetSumMatches(arr, sum1, n);

        System.out.println("Count "+count);
    }
}