package org.example.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElemnts {
    public static void main(String[] args)
    {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            minHeap.add(arr[i]);

            if(minHeap.size()>k)
            {
                System.out.println(arr[i]);
                arr[j]= minHeap.poll();
                j++;
            }
        }

        while(!minHeap.isEmpty())
        {
            arr[j]=minHeap.poll();
            j++;
        }

        System.out.println(Arrays.toString(arr));

    }
}
