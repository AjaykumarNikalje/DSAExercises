package org.example.MatrixChainMultiplication;

public class MCMRecursive {

    public static int mcmRecursive(int[] arr,int i,int j){

        //base condition.
        if(i>=j){
        return 0;
        }
        int min= Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int temp=mcmRecursive(arr,i,k) +
                     mcmRecursive(arr,k+1,j) +
                    ( arr[i-1] * arr[k] * arr[j] );
            min=Math.min(min,temp);
        }
        return min;
    }
    public static void main(String[] args) {
        //int [] inputArray = {2, 1, 3, 4}  ;
        //int [] inputArray = {1, 2, 3, 4, 3} ;
        int [] inputArray = {3, 4} ;
        int i = 1;
        int j = inputArray.length-1;

        int result = mcmRecursive(inputArray, i, j);
        System.out.println("Result is here : "  +result);
    }
}
/*Input: p[] = {40, 20, 30, 10, 30}
Output: 26000
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input: p[] = {10, 20, 30, 40, 30}
Output: 30000
There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input: p[] = {10, 20, 30}
Output: 6000
There are only two matrices of dimensions 10x20 and 20x30. So there
is only one way to multiply the matrices, cost of which is 10*20*30
*/


/*
i and 𝑗
j: Indices defining the range of matrices being multiplied.
Base Condition: 𝑖 ≥ 𝑗 → 0.
For Loop: Iterates over possible splits.
Recursion: Calculates costs for subproblems and combines results.
*/