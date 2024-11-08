package org.example.BackTracking;

import java.util.Arrays;

public class NQueensBacktracking {

    public static boolean isAllowed(int[][] mat,int size,int colIndex,int rowIndex){

        boolean isAllowed=false;

        //check if the row has queen.
        for(int col=0;col<colIndex;col++)
        {
            if(mat[rowIndex][col]==1)
            {
                isAllowed=false;
                return isAllowed;
            }
        }

        //check if the upper left diagonals have queen.
        int row=rowIndex;
        int col=colIndex;
        while(row>=0 && col>=0)
        {
            if(mat[row][col]==1)
            {
                isAllowed=false;
                return isAllowed;
            }
            row--;
            col--;
        }

        row=rowIndex;
        col=colIndex;
        while(row<size && col>=0)
        {
            if(mat[row][col]==1)
            {
                isAllowed=false;
                return isAllowed;
            }
            row++;
            col--;
        }
        return true;
    }
    public static void resolve(int[][] mat,int size,int colIndex,int[] curLoopResult) {
        if (size == colIndex ) {
            System.out.println(Arrays.toString(curLoopResult));
            return;
        }

        // iterating through the array.
        for (int rowIndex = 0; rowIndex < size; rowIndex++){
            if(isAllowed(mat,size,colIndex,rowIndex) ) {
                mat[rowIndex][colIndex] = 1;
                curLoopResult[colIndex] = rowIndex + 1;

                resolve(mat, size, colIndex + 1, curLoopResult);
                mat[rowIndex][colIndex] = 0;
                curLoopResult[colIndex] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        int input=4;
        int[][] mat=new int[input][input];
        int[] currentLoopResult=new int[input];

        resolve(mat,input,0,currentLoopResult);


    }
}
