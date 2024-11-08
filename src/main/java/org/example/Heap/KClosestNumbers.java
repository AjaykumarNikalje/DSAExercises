package org.example.Heap;

import javafx.util.Pair;

import java.util.PriorityQueue;

public class KClosestNumbers {

    public static void main(String[] args)
    {
        int[] arr =  {10, 2, 14, 4, 7, 6};
        int k = 3;
        int x = 5;
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());


        for(int i=0;i<arr.length;i++)
        {

            maxHeap.add(new Pair( Math.abs(arr[i]-x) , arr[i]));

            if(maxHeap.size()>k)
            {
                maxHeap.poll();
            }
        }
        while(!maxHeap.isEmpty())
        {
            System.out.println(maxHeap.poll().getValue() );
        }
    }
}
