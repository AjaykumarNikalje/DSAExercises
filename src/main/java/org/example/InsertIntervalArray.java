package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class InsertIntervalArray {
    public static List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }
public static List<int[]> InsertInterval(int[][] intervals, int[] newInterval)
{
    ArrayList<int[]> list=new ArrayList<>();
    int i=0;
    int size=intervals.length;
    System.out.println("The size of the array is "+size);

    while(i<size && intervals[i][1]< newInterval[0] )
    {
        list.add(intervals[i]);
        System.out.println("first while " +Arrays.toString(intervals[i]));
        i++;
    }

    while(i<size && intervals[i][0]<= newInterval[1])
    {
        newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
        newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
        i++;
        System.out.println("For i "+i+" newInterval[0] " +newInterval[0]  +"newInterval[1] " +newInterval[1]);
    }

    list.add(newInterval);
    System.out.println("first while " +Arrays.toString(intervals[i]));


    while(i<size)
    {
        list.add(intervals[i]);
        i++;
        System.out.println("Current i value is "+i);
    }
    return list;
}

    public static void main(String[] args){
        int[][] intervals = new int[][]{
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };

        int[] newInterval={4,8};

        List<int[]> lst=InsertInterval(intervals, newInterval);
        for (int i = 0; i < lst.size(); i++) {
            System.out.println( i+": "+ Arrays.toString(lst.get(i)) );
        }

    }

}
