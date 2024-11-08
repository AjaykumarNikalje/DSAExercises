/*
Introduction
The Two Sum problem is a classic algorithmic challenge frequently encountered in coding interviews. The task is to find two numbers in a sorted array that add up to a specific target number. Given that the array is already sorted, we can leverage this property to solve the problem efficiently using a two-pointer technique. This article will walk through the approach, provide a clear algorithm, and show implementations in both Python and Java.

Problem Statement
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length. Return the indices of the two numbers as an integer array [index1, index2] of length 2.

Constraints:
The input array is sorted in non-decreasing order.
There is exactly one solution, and you may not use the same element twice.
Your solution must use only constant extra space.


 */
package org.example;

import java.util.Arrays;
class TwoSum2Array {
    public static int[] twoSum(int[] numbers, int target) {
        int f = 0, s = numbers.length - 1;
        int[] ans = new int[2];

        while (f < s) {
            int sum = numbers[f] + numbers[s];
            if (sum < target) {
                f++;
            }
            else if (sum > target) {
                s--;
            }
            else {
                ans[0] = f + 1;
                ans[1] = s + 1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] numbers=new int[]{1, 3, 4, 8, 9};
        int val = 11;
       System.out.println(Arrays.toString(twoSum(numbers,val)));
    }
}