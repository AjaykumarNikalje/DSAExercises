package org.example.Heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopesToMinimiseCost {
    public static void main(String[] args)
    {
        int[] arr ={4,3,2,6} ;
        int n=4;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( );


        for(int i=0;i<arr.length;i++)
        {
            minHeap.add( arr[i] );
        }

        int minCost=0;
        while(!minHeap.isEmpty())
        {
            int first=minHeap.poll();
            int second= 0;

            if(!minHeap.isEmpty())
           {
               second=minHeap.poll();
               minHeap.add(first+second);
               minCost=minCost+(first+second);
           }
        }
        System.out.println("The minimum cost to connect the ropes " + minCost);
    }
}
