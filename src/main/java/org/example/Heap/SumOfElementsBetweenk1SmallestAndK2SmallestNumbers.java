package org.example.Heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumOfElementsBetweenk1SmallestAndK2SmallestNumbers {

    public static void main(String[] args)
    {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1=3;
        int k2=6;
        int SumOfElementsBetweenK1AndK2=0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b-a );


        for(int i=0;i<arr.length;i++)
        {
            maxheap.add(arr[i]);
        }

        while(!maxheap.isEmpty())
        {
           if(maxheap.size()>k1 && maxheap.size()<k2)
           {
               SumOfElementsBetweenK1AndK2=SumOfElementsBetweenK1AndK2+maxheap.poll();
           }
           else {
               maxheap.poll();
           }
        }
    System.out.println("The sum of elements between k1 and k2 : "+SumOfElementsBetweenK1AndK2);
    }
}
