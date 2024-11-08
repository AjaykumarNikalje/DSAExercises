package org.example;

public class RotateImageOptimizedTest {


    public static void rotate(int[][] matrix) {

        int size=matrix.length;
        for(int layer=0; layer<size/2; layer++)
        {
            int first=layer;
            int last=size-1-layer;

            for(int i=first;i<last;i++ )
            {
                int offset=i-first;

                //Getting the top element in the variable.
                int top=matrix[first][i];

                //Copying the left element to top.
                matrix[first][i]=matrix[last-offset][first];

                //Copying the bottom element to left.
                matrix[last-offset][first]=matrix[last][last-offset];

                //Copying the right element to bottom.
                matrix[last][last-offset]=matrix[i][last];

                //Copying top element to right.
                matrix[i][last]=top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}
                };

        rotate(matrix);


        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
