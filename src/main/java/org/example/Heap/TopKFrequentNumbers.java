package org.example.Heap;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentNumbers {


    public static void main(String[] args)
    {
        int[] arr =  {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        HashMap<Integer,Integer> freqMap=new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            int curNum=arr[i];
            if(freqMap.containsKey(curNum))
            {
                freqMap.put(curNum,freqMap.get(curNum)+1);
            }
            else {
                freqMap.put(curNum,1);
            }
        }

        for (Integer key : freqMap.keySet()) {
            Integer value = freqMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);

            minHeap.add(new javafx.util.Pair( value , key));

            if(minHeap.size()>k)
            {
                minHeap.poll();
            }
        }

        while(!minHeap.isEmpty())
        {
            System.out.println(minHeap.poll().getValue() );
        }
    }
}
