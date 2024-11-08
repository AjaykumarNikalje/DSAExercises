package org.example.dynamicProgramming;

import java.util.Arrays;

public class PartitionSetIntoTwoEqualSubsetsRecursion {

    public static boolean isSubsetSumEqual(int[] arr,int subSetSum ,int n)
    {
        if(subSetSum==0){
            return true;
        }
        if(n==0)
        {
            return false;
        }

        if(arr[n-1]<=subSetSum)
        {
            return ( isSubsetSumEqual(arr,subSetSum,n-1) ||  isSubsetSumEqual(arr,subSetSum-arr[n-1],n-1) );
        }
        else {
            return isSubsetSumEqual(arr,subSetSum,n-1);
        }
    }

    public static void main(String[] args){
    int[] arr={1,5,11,5};
    int sum=Arrays.stream(arr).sum();
    boolean isSubsetEqualFound;

    if(sum%2==0){
        isSubsetEqualFound= isSubsetSumEqual(arr,sum/2,arr.length-1);
    }
    else {
        isSubsetEqualFound= false;
    }
        if (isSubsetEqualFound) {
            System.out.println("Two equal sub sets are found");
        } else {
            System.out.println("Two equal sub sets are not found");
        }
    }
}
