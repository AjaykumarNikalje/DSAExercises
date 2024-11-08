/*

https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/
Purpose:

The code finds the maximum product of a contiguous subarray within an integer array.
Initialization:

maxPro is initialized to the smallest possible integer to store the maximum product found.
pre and suff are set to 1 to track the product of elements in the forward and backward directions, respectively.
Loop Through Array:

The loop iterates over each element in the array from both the front (pre) and back (suff) simultaneously.
Handling Zeroes:

If pre or suff becomes zero, it is reset to 1 to start fresh multiplication after encountering a zero.
Calculate Products:

Multiply the current element to pre for the forward pass and to suff for the backward pass.
Update Maximum Product:

At each step, update maxPro with the greater value between pre, suff, and the current maxPro.
Return Result:

The maximum product found is returned as an integer.
Main Method:

Demonstrates how to use the maxProduct function with an example array and prints the result.
*/

package org.example;
public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {
        double maxPro = Integer.MIN_VALUE;
        double pre = 1, suff = 1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre *= nums[i];
            suff *= nums[len - i - 1];

            maxPro = Math.max(maxPro, Math.max(pre, suff));
        }

        return (int) maxPro;
    }

    public static void main(String[] args) {
        int[] nums = {6, -3, -10, 0, 2};
        System.out.println("The maximum product subarray: " + maxProduct(nums));
    }
}
