package org.example.Heap;

import java.util.PriorityQueue;

public class KthSmallestElemnt {

    public static void main(String[] args)
    {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a, b) -> b - a);;

        for(int i=0;i<arr.length;i++)
        {
            maxHeap.add(arr[i]);

            if(maxHeap.size()>k)
            {
                System.out.println(arr[i]);
                maxHeap.poll();
            }
        }
        System.out.println("The kth Smallest Element "+maxHeap.peek());
    }
}
