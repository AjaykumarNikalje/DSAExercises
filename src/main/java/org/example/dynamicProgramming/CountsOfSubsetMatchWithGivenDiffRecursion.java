package org.example.dynamicProgramming;

import java.util.Arrays;

//Count the number of subset with a given difference
public class CountsOfSubsetMatchWithGivenDiffRecursion {

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
        int[] arr={1, 2, 3, 1, 2};
        int diff=1;
        int n=arr.length;
        int totalSum= Arrays.stream(arr).sum();

    /*
    sum1-sum2=diff;
    sum1+sum2=totalSum;
    2sum1=diff+totalSum
    */
    int sum1=( (diff + totalSum) / 2);
    int count = countOfSubsetSumMatches(arr, sum1, n);

    System.out.println("Count "+count);
    }
}