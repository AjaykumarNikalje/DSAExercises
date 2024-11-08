package org.example;
import java.util.Arrays;
public class RotateImageOptimized {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Perform the rotation layer by layer
        for (int layer = 0; layer < n / 2; layer++) {

            System.out.println(Arrays.toString(matrix[layer]));
            System.out.println("Loop Start:");

            int first = layer;
            int last = n - 1 - layer;

            System.out.println(" first "+first+ " layer "+layer+ " last "+last);

            for (int i = first; i < last; i++) {
                int offset = i - first;

                System.out.println("The offset is "+offset);
                // Save the top element
                int top = matrix[first][i];

                System.out.println("top "+top);

                // Left -> Top
                matrix[first][i] = matrix[last - offset][first];

                // Bottom -> Left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Right -> Bottom
                matrix[last][last - offset] = matrix[i][last];

                // Top -> Right
                matrix[i][last] = top;

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
