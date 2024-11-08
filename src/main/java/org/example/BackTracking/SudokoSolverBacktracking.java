package org.example.BackTracking;

import java.util.Arrays;

public class SudokoSolverBacktracking {

    public static boolean isValidToPut(int[][] board,int rowIndex,int colIndex,int num)
    {

        System.out.println( "board["+rowIndex+"]["+colIndex+"] "+board[rowIndex][colIndex] +" and num "+num  );
        
        // check for current column and row.
        for(int i=0;i<board.length;i++)
        {
            if(board[rowIndex][i]==num || board[i][colIndex]==num)
            {
                System.out.println( "The number is already present in either row or columns." );
                return false;
            }
        }

        // check for current 3*3 matrix
        int startRowIndexOfMatrix= (rowIndex/3) * 3;
        int startColIndexOfMatrix= (colIndex/3) * 3;

        for (int i=startRowIndexOfMatrix;i<startRowIndexOfMatrix+3;i++) {
            for (int j = startColIndexOfMatrix; j < 3+startColIndexOfMatrix; j++) {
              if(board[i][j]==num)
                {
                    System.out.println( "The number is already present in matrix." );
                    return false;
                }
            }
        }
        System.out.println( "The number is not present in matrix." );
        return true;
    }
public static boolean solveSudoku(int[][] board,int rowIndex,int colIndex)
{
   if(rowIndex>=board.length){
        System.out.println("rowIndex==board.length ");
        return true;
    }

    if (colIndex>=board.length){
        System.out.println("colIndex==board.length");
        return solveSudoku(board, rowIndex+1, 0);

    }

    System.out.println( "rowIndex: " +rowIndex +" colIndex: " +colIndex    );

    // when cell is already filled, move to the next column cell in the current row.
    if(board[rowIndex][colIndex]>0)
    {
        System.out.println("board[rowIndex][colIndex]>0");
        return solveSudoku(board, rowIndex, colIndex+1);
    }
   else {
        // iterate through
        for (int k = 1; k <= 9; k++) {
            System.out.println("board[" + rowIndex + "][" + colIndex + "] " + board[rowIndex][colIndex] + " and k " + k);
            if (isValidToPut(board, rowIndex, colIndex, k)) {
                System.out.println("We can put " + k + " in matrix: ");
                board[rowIndex][colIndex] = k;
                if (solveSudoku(board, rowIndex, colIndex + 1)) {
                    return true; // Continue solving
                }
                board[rowIndex][colIndex] = 0; // Backtrack
            }
        }
    }
 return false;
}
    public static void main(String[] args){

        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 },
        };
        //System.out.println(Arrays.toString(board));
        solveSudoku(board, 0, 0);

        System.out.println(Arrays.deepToString(board));
    }
}

