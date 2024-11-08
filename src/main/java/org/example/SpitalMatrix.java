package org.example;

import java.util.ArrayList;
import java.util.List;

public class SpitalMatrix {

    public static List<Integer> getMatrixValuesInSpiralOrder(int[][] matrix)
    {
        int colStart=0;
        int colEnd=matrix[0].length;

        int rowStart=0;
        int rowEnd=matrix.length;

        List<Integer> finalList=new ArrayList<>();

        while(colStart<colEnd && rowStart<rowEnd)
        {
            // Go through the first row
            for(int i = colStart; i<colEnd; i++)
            {
                finalList.add(matrix[rowStart][i]);
            }
            rowStart++;

            System.out.println(" rowStart: "+rowStart);

            // Go through the Last column
            for(int i=rowStart;i<rowEnd;i++)
            {
                finalList.add(matrix[i][colEnd-1]);
            }
            colEnd--;
            System.out.println(" colEnd: "+colEnd);

            // Go through the last row
            for(int i = colEnd-1; i>=colStart; i--)
            {
                finalList.add(matrix[rowEnd-1][i]);
            }
            rowEnd--;
            System.out.println(" rowEnd: "+rowEnd);

            // Go through the First column
            for(int i=rowEnd-1;i>=rowStart;i--)
            {
                finalList.add(matrix[i][colStart]);
            }
            colStart++;
            System.out.println(" colStart: "+colStart);

            System.out.println("------Loop Iteration Completed------");

        }

        return finalList;
    }
    public static void main(String[] args) {
        int[][] matrix =
                {
                   {1,    2,   3,   4},
                   {5,    6,   7,   8},
                   {9,   10,  11,  12},
                   {13,  14,  15,  16}
                };

        List<Integer> lst=getMatrixValuesInSpiralOrder(matrix);

        for (Integer element : lst) {
            System.out.println("  "+element);
        }

    }
}
