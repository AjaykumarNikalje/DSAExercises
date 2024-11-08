package org.example.BackTracking;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class LargestNumberKSwapsBackTracking {
    //swap function to swap two characters from indices idx and idx2
    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void solve(char[] arr, int cur,int k,ArrayList<Integer> finalNos) {

        if (cur == arr.length - 1 || k==0) {
            finalNos.add( Integer.parseInt(String.valueOf(arr)) );
            return;
        }

        int max= Integer.MIN_VALUE;
        for(int j=cur+1;j<arr.length;j++)
        {
            //System.out.println(arr[j]);
            max=Math.max(max, arr[j] - '0');
        }

        boolean isSwapped=false;
        for (int i = cur; i < arr.length; i++) {
            if( !(i == cur) && (arr[cur]- '0'<arr[i]- '0' && arr[i]- '0'==max) ) {
                isSwapped=true;
                swap(arr, cur, i);
                k--;
                solve(arr, cur + 1,k,finalNos);
                swap(arr, cur, i);
            }

        }

        if (!isSwapped) {
            solve(arr, cur + 1, k,finalNos);
        }
    }

    public static void main(String[] args) {
        String str = "7599";
        int k =2;
        if (str.length() == 0 || str == null) {
            return;
        }
        ArrayList<Integer> finalNos=new ArrayList<>();
        solve(str.toCharArray(), 0,k,finalNos);
        System.out.println("Largest number after " + k + " swaps is: " + Collections.max(finalNos));
    }
}
