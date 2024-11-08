package org.example.dynamicProgramming;

import java.util.Arrays;

public class RodCuttingRecursion {

    public static int knapSack(int[] weight,int[] profit,int w,int n)  {

        // base condition
        if(n==0 || w==0)
        {
            return 0;
        }

        // hypothesis and induction step.
        if(weight[n-1]<=w)
        {
            return Math.max(
                    knapSack(weight,profit,w,n-1),
                    profit[n-1] + knapSack(weight,profit,w-weight[n-1],n)
            );
        }
        else if(weight[n-1]>w)
        {
            return knapSack(weight,profit,w,n-1);
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args)
    {


        int[] price= {1,5,8,9,10,17,17,20};
        int[] len=new int[price.length];
        int n=price.length;

        for(int i=0;i<n;i++)
        {
            len[i]=i+1;
        }
        System.out.println(Arrays.toString(len));
        System.out.println(Arrays.toString(price));
        System.out.println( "max price: "+knapSack(len,price,n,n) );

    }
}
