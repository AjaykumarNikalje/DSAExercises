package org.example.recursion;
import java.math.*;
public class KthSymbolInGrammer {

    public static int searchKthSymbol(int n,int k){
        //base condition
        if(n==1 && k==1){
            return 0;
        }

        int mid= (int) Math.pow(2,n-1) / 2;
        System.out.println("Mid value: "+mid);

        if(k<=mid){
            return searchKthSymbol(n - 1, k);
        }
        else
        {
            return 1-searchKthSymbol(n - 1, k-mid);
        }
    }

    public static void main(String[] args){
        /*
        0
        01
        0110
        01101001
         */
        int n=4,k=5;
        System.out.println("the kth element in the grammer: " +searchKthSymbol(n,k));
    }
}
