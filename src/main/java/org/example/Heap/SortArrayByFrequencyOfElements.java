package org.example.Heap;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortArrayByFrequencyOfElements {

    public static void main(String[] args)
    {
        int[] arr =   {1, 3, 2, 2, 2 ,3 ,4 ,3, 1};


        HashMap<Integer,Integer> freqMap=new HashMap<>();
        HashMap<Integer,Integer> indexMap=new HashMap<>();


        PriorityQueue<Pair<Integer, Integer>> maxheap = new PriorityQueue<>((a, b) -> (b.getKey()==a.getKey())? indexMap.get(a.getValue()) -indexMap.get(b.getValue())  : b.getKey()-a.getKey() );

        for(int i=0;i<arr.length;i++)
        {
            int curNum=arr[i];
            if(freqMap.containsKey(curNum))
            {
                freqMap.put(curNum,freqMap.get(curNum)+1);
            }
            else {
                freqMap.put(curNum,1);
                indexMap.put(curNum,i);
            }
        }

        for (Integer key : freqMap.keySet()) {
            Integer value = freqMap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);

            maxheap.add(new javafx.util.Pair( value , key));

        }

        while(!maxheap.isEmpty())
        {
            Pair<Integer, Integer> curElement=maxheap.poll();
            for(int i=0;i<curElement.getKey();i++)
            {
                System.out.println(curElement.getValue());
            }
        }
    }
}
