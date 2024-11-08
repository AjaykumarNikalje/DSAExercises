package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static int getMinIntervalsToBeRemoved(int[][] intervals){
        int size=intervals.length;
       Arrays.sort(intervals,Comparator.comparingInt(i->i[1]));

       for (int[] interval:intervals) {
           System.out.println(Arrays.toString(interval));
       }

       int[] currentArray=intervals[0];
       int minIntervalsNeedstoBeRemoved=0;

       for(int i=1;i<size;i++)
       {
           System.out.println("Last Valid Array"+Arrays.toString(currentArray));
           System.out.println("Current array"+Arrays.toString(intervals[i]));

           if(currentArray[1]>intervals[i][0])
           {
               minIntervalsNeedstoBeRemoved++;
               System.out.println("Array needs to be removed "+Arrays.toString(intervals[i]));

           }
           else {
               currentArray=intervals[i];
           }
       }
        return minIntervalsNeedstoBeRemoved;
    }

    public static void main(String[] args){
        //int[][] intervals={{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals={{1,2},{1,2},{1,2}};
        //int[][] intervals={{1,2},{2,3},{3,4}};
        //int[][] intervals={{1, 2}, {4, 7}, {3, 8}};
        System.out.println("The minimum intervals need to be removed: "+getMinIntervalsToBeRemoved(intervals));
    }
}
