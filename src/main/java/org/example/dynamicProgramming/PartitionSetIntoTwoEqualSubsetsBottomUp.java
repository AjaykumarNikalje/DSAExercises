package org.example.dynamicProgramming;

import java.util.Arrays;

public class PartitionSetIntoTwoEqualSubsetsBottomUp {


    public static boolean isSubsetSumEqual(int[] arr,int subSetSum )
    {
        int rowLen=arr.length;
        int colLen=subSetSum;
        boolean[][] t=new boolean[rowLen+1][colLen+1];

        for (int i=0;i<=rowLen;i++)
        {
            t[i][0]=true;
        }
        for(int j=1;j<=colLen;j++)
        {
            t[0][j]=false;
        }

        for(int i=1;i<=rowLen;i++){
            for(int j=1;j<=colLen;j++)
            {
                if(arr[i-1]<=j)
                {
                    t[i][j]= (
                             t[i-1][j]
                             ||
                             t[i-1][j-arr[i-1]]
                            );
                }
                else{
                    t[i][j] =t[i-1][j];
                }
            }
        }
        return t[rowLen][colLen];
    }

    public static void main(String[] args){
        int[] arr={1,5,11,5};
        int sum= Arrays.stream(arr).sum();
        boolean isSubsetEqualFound;

        if(sum%2==0){
            isSubsetEqualFound= isSubsetSumEqual(arr,sum/2);
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
