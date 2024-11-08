package org.example;

import java.util.Arrays;
public class RotateArraybyKposition {

    public static void main(String[] args) {

        int[] num = new int[] {1, 2, 3, 4};
        int size=num.length;
        int[] temp=new int[4];
        int k=3;
        k=k % size;

        System.out.println(Arrays.toString(num));
        for(int i=0;i<size;i++)
        {
            temp[ (i+k) % size]=num[i];
        }
        num=temp;
        System.out.println(Arrays.toString(num));

    }
}
