package org.example.dynamicProgramming;


public class CountsOfSubsetMatchWithGivenSumRecursion {

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
        int[] arr={1, 2, 3, 3};
        int sum=6;
        int n=arr.length;
        int count = countOfSubsetSumMatches(arr, sum, n);

       System.out.println("Count "+count);
    }
}
