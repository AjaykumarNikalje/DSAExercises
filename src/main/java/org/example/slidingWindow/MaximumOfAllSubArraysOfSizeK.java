package org.example.slidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MaximumOfAllSubArraysOfSizeK {

    public static void main(String[] args)
    {
        int[] arr={1, 3, -1, -3, 5, 3, 6, 7} ;
        int k=3;
        Queue<Integer> que=new LinkedList<>();
        int i=0;
        int j=0;
        Vector finalLst=new Vector();
        while(j<arr.length)
        {
            if(j-i+1 < k)
            {
                System.out.println("j "+j +" And arr[j] "+arr[j]);
                System.out.println( "que.peek() "+que.peek());

                if(que.size()>0 && arr[j]>que.peek() )
                {
                   while(que.size()>0)
                   {
                       que.poll();
                   }
                }
                que.add(arr[j]);
            }
            else
            {
                if(que.size()>0 && arr[j]>que.peek())
                {
                    while(que.size()>0)
                    {
                        que.poll();
                    }
                }
                que.add(arr[j]);
                finalLst.add(que.peek());
                i++;
            }
            j++;
        }

        System.out.println(finalLst.toString() );

    }

}
