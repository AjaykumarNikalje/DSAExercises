package org.example;
import java.util.Arrays;
public class SetZeroMatrix {
    public static int[][] getZeroMatrix(int[][] arr)
    {
        int rowsSize=arr.length;
        int colsSize=arr[0].length;
        int cols=1;
        System.out.println("The row size of the length: "+rowsSize);
        System.out.println("The cols size of the length: "+colsSize);

        for (int i=0;i<rowsSize;i++)
        {
            for (int j=0;j<colsSize;j++)
            {
                System.out.println("The row column i "+i+" j "+j+" value "+arr[i][j]);
                if(arr[i][j]==0){
                    System.out.println("We got zero.");
                    if (i==0){
                        arr[i][0]=0;
                    if(j==0)
                    {
                        cols=0;
                    }
                    }
                    else {
                        arr[0][j]=0;
                        arr[i][0]=0;
                    }

                    System.out.println("The row column i "+i+" j 0 value "+arr[i][0]);
                    System.out.println("The row column i 0 j "+j+" value "+arr[0][j]);
                }
            }
        }

        for (int i=1;i<rowsSize;i++)
        {
            for (int j=1;j<colsSize;j++)
            {
                if(arr[0][j]==0)
                {
                    arr[i][j]=0;
                }

                if(arr[i][0]==0)
                {
                    arr[i][j]=0;
                }

            }
        }

        for (int i=1;i<rowsSize;i++)
        {
            for (int j=1;j<colsSize;j++)
            {
                if(arr[0][j]==0 || arr[i][0]==0)
                {
                    arr[i][j]=0;
                }
            }
        }

        // Finally mark the 1st row then 1st col:
        if (arr[0][0] == 0) {
            Arrays.fill(arr[0], 0);
        }
        if (cols == 0) {
            for (int i = 0; i < rowsSize; i++) {
                arr[i][0] = 0;
            }
        }


        System.out.println("After updating with zero.");

        for (int i=0;i<rowsSize;i++)
        {
            for (int j=0;j<colsSize;j++)
            {
                System.out.println("The row column i "+i+" j "+j+" value "+arr[i][j]);
                if(arr[i][i]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args){

        /*
        int[][] arr={

                  {1,1,1},
                  {1,0,1},
                  {1,1,1}
                };
         */

        int[][] arr = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } };
    int[][] zeroMatrix=getZeroMatrix(arr);
    }
}
