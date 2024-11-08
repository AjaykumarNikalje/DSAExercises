package org.example.recursion;

public class Print1toN {

    public static void print(int n){
        // base condition
        if(n == 0){
            return;
        }
        System.out.print(n);
        print(n - 1);


    }

    public static void main(String[] args){
        int n = 8;
        print(n);
    }
}

