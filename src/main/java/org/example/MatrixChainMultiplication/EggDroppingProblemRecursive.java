package org.example.MatrixChainMultiplication;

public class EggDroppingProblemRecursive {

    public static int solve(int floor, int eggs){
     // base condition
     if(eggs==0)
     {
         return 0;
     }

     if(eggs==1){
       return floor;
     }

    if(floor==0 || floor==1) {
    return floor;
    }
    int minAttemps= Integer.MAX_VALUE;
    for(int k=1;k<=floor;k++)
    {
        int attempts= 1 + Math.max(solve(k-1,eggs-1),solve(floor-k,eggs) )  ;
        minAttemps=Math.min(minAttemps,attempts);
    }
    return minAttemps;
    }

    public static void main(String[] args)
    {
        int floor=4;
        int eggs=2;

        System.out.println("The minimum number of attempts to find the highest floor "+ solve(floor,eggs));
    }
}


