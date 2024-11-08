package org.example.dynamicProgramming;

public class SubsetSumProblemBottomUp {

    public static boolean IsSubsetSumMatches(int[] arr,int sum){
        int rowLen=arr.length;
        int colLen=sum;
        boolean [][] t=new boolean[rowLen+1][colLen+1];

        for(int i=0;i<=rowLen;i++)
        {
            t[i][0]=true;
        }

        for(int j=1;j<=colLen;j++)
        {
            t[0][j]=false;
        }

        for (int i=1;i<=rowLen;i++)
            for (int j=1;j<=colLen;j++)
            {
               if( arr[i-1]<=j )
              {
                 t[i][j]= ( t[i-1][j-arr[i-1]] || t[i-1][j] );
              }
              else{
                   t[i][j]=t[i-1][j];
              }
            }

        return t[rowLen][colLen];
    }

public static void main(String[] args){
    int[] arr={1,2,4,5};
    int sum=5;

    boolean isMatched = IsSubsetSumMatches(arr,sum);
    if (isMatched) {
        System.out.println("There is a subset with the given sum.");
    } else {
        System.out.println("No subset with the given sum.");
    }


}
}
