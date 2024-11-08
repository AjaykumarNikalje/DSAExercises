package org.example.Heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args)
    {
        int[][] arr = {{3, 3}, {5, -1}, {-2, 4}};
        int k=2;
        PriorityQueue<Pair<Integer, int[]>> maxheap = new PriorityQueue<>((a, b) -> b.getKey()-a.getKey() );


        for(int i=0;i<arr.length;i++)
        {

            int sum=(arr[i][0] * arr[i][0] ) + (arr[i][1] * arr[i][1]);
            System.out.println(Arrays.toString(arr[i]) +"sum  "+sum);
            maxheap.add( new javafx.util.Pair( sum, arr[i] ));

            if(maxheap.size()>k)
            {
                System.out.println("Inside maxHeap.size()>k condition.");
                maxheap.poll();
            }
        }

        while(!maxheap.isEmpty())
        {
            Pair<Integer, int[]> curElement=maxheap.poll();
            System.out.println("Final Answer : "+Arrays.toString(curElement.getValue()));
        }

    }
}
