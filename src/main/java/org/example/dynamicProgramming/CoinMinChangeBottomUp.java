package org.example.dynamicProgramming;

public class CoinMinChangeBottomUp {

    public static int countOfSubsetSumMatches(int[] arr,int sum){
        int rowLen=arr.length;
        int colLen=sum;
        int [][] t=new int[rowLen+1][colLen+1];

        System.out.println("rowLen "+rowLen +" colLen "+colLen);

        for(int i=0;i<=rowLen;i++)
        {
            t[i][0]=0;
        }

        for(int j=1;j<=colLen;j++)
        {
            t[0][j]= Integer.MAX_VALUE-1;
        }

        for(int j=1;j<=colLen;j++)
        {
            if(j%arr[0] ==0)
            {
                t[1][j]=1;
            }
            else {
                t[1][j]= Integer.MAX_VALUE-1;
            }
        }

        for (int i=2;i<=rowLen;i++)
            for (int j=1;j<=colLen;j++)
            {
                if( arr[i-1]<=j )
                {
                    t[i][j]= Math.min( 1 + t[i][j-arr[i-1]] , t[i-1][j] );
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }

        return t[rowLen][colLen];
    }

    public static void main(String[] args){
        int[] coins = {25,10,5};
        int sum = 30;

        int result = countOfSubsetSumMatches(coins,sum);

        // If result is still a large value, that means it's not possible to make the sum
        if (result >= Integer.MAX_VALUE - 1) {
            System.out.println("Not possible to make the sum with the given coins");
        } else {
            System.out.println("Minimum coins required: " + result);
        }
    }
}

