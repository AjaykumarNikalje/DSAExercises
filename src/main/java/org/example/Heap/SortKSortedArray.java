package org.example.Heap;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args)
    {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++)
        {
            minHeap.add(arr[i]);

            if(minHeap.size()>k)
            {
                System.out.println(arr[i]);
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty())
        {
            System.out.println("The kth Smallest Element "+minHeap.poll());
        }

    }
}
