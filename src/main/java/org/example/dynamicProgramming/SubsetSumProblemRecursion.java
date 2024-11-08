package org.example.dynamicProgramming;

public class SubsetSumProblemRecursion {

    public static boolean isSubsetSumMatches(int[] arr,int sum,int n)
    {
        // base condition
        if(n==0 )
        {
            return false;
        }

        if(sum==0)
        {
            return true;
        }

        if(arr[n-1]<=sum) {
            return (

                    isSubsetSumMatches(arr, sum, n - 1)
                    ||
                    isSubsetSumMatches(arr, sum-arr[n-1], n - 1)
                   );
        }
        else {
            return isSubsetSumMatches(arr, sum, n - 1);
        }
    }
    public static void main(String[] args){
        int[] arr={3,34,3,12,5,2};
        int sum=15;
        int n=arr.length;
        boolean isMatched = isSubsetSumMatches(arr, sum, n);
        if (isMatched) {
            System.out.println("There is a subset with the given sum.");
        } else {
            System.out.println("No subset with the given sum.");
        }
    }
}
