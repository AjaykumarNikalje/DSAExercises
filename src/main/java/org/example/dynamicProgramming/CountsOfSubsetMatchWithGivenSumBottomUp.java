package org.example.dynamicProgramming;

public class CountsOfSubsetMatchWithGivenSumBottomUp {

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
        int[] arr={1, 2, 3, 3};
        int sum=3;

        int count = countOfSubsetSumMatches(arr,sum);

        System.out.println("Count "+count);


    }
}

