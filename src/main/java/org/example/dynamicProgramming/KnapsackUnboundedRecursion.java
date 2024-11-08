package org.example.dynamicProgramming;
public class KnapsackUnboundedRecursion {

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

        int w=8;
        int[] profit= {10,40,50,70};
        int[] weight={1,3,4,5};
        int n=profit.length;
        System.out.println( "profit: "+knapSack(weight,profit,w,n) );

    }
}
