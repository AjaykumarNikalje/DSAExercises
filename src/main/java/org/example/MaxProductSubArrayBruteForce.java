package org.example;
public class MaxProductSubArrayBruteForce {

    public static int maxSubArrayProduct(int[] arr){
        int size=arr.length-1;
        int maxProduct=Integer.MIN_VALUE;

        for (int i=0;i<size;i++)
        {
            int localProduct=1;
            for (int j=i;j<size;j++){
                localProduct*=arr[j];
                maxProduct=Integer.max(maxProduct,localProduct);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        int size = arr.length;
        System.out.println("The maximum product subarray: " + maxSubArrayProduct(arr));
    }
}

