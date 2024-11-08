package org.example.binarySearch;

public class SearchInRowwiseAndColumnWiseSortedArray {

    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int x = 0;

        int rowLen = mat.length;
        int colLen = mat[0].length;
        int i = 0;
        int j = mat[0].length-1;
        int[] position= {-1,-1};
        while ( (i < rowLen  && i>=0) && (j < colLen  && j >=0) ) {

           if(mat[i][j]==x )
           {
             position[0]=i;
             position[1]=j;
             break;
           }
           else if(mat[i][j]> x)
           {
               j--;
           }
           else if(mat[i][j]< x)
           {
               i++;
           }
        }

        if(position[0] >=0 && position[1]>=0)
        {
            System.out.println(" The element found at ( "+ i +" , "+j +")");
        }
        else
        {
            System.out.println(" Not Found ");
        }

    }
}
