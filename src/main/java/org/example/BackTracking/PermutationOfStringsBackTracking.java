package org.example.BackTracking;

import java.io.*;
import java.util.*;

public class PermutationOfStringsBackTracking {

    //swap function to swap two characters from indices idx and idx2
    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void solve(char[] arr, int idx) {
        if (idx == arr.length - 1) { //Base condition of recursion
            System.out.print(String.valueOf(arr) + " ");
        }

        ArrayList<Character> charTracker= new ArrayList<>();
        for (int i = idx; i < arr.length; i++) {

            if(charTracker.indexOf(arr[i])==-1) {
            charTracker.add(arr[i]);
            swap(arr, idx, i);
            solve(arr, idx + 1);
            swap(arr, idx, i);
            }
            //Backtracking: reverting all the elements to their original places
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        if (str.length() == 0 || str == null) {
            return;
        }
        solve(str.toCharArray(), 0); //function call to find all the permutations
        //toCharArray() converts a given string into a character array

    }
}
