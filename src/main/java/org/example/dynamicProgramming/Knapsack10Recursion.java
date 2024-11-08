package org.example.dynamicProgramming;
public class Knapsack10Recursion {

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
                    profit[n-1] + knapSack(weight,profit,w-weight[n-1],n-1)
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
        int n=3;
        int w=4;
        int[] profit={1,2,3};
        int[] weight={4,5,1};

        System.out.println( "profit: "+knapSack(weight,profit,w,n) );

    }
}
