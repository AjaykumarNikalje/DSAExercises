/*
Explanation:
Arrays.sort(intervals, ...): This is a method in Java used to sort arrays. In this case, intervals is a 2D array, where each element is an array representing an interval (e.g., [start, end]).

Comparator.comparingInt(i -> i[0]): This part of the code defines the sorting logic using a comparator.

Comparator.comparingInt(...): This is a method that creates a Comparator for comparing int values.

i -> i[0]: This is a lambda expression. The i represents each element in the intervals array (which itself is an array representing an interval). The expression i[0] accesses the first element of this interval (the start of the interval).
 */
package org.example;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

public static List<int[]> MergeIntervals(int[][] intervals){
    ArrayList<int[]> lst=new ArrayList<>();
    Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

    int[] newInterval=intervals[0];
    System.out.println(newInterval[0]+"   "+newInterval[1]);
    lst.add(newInterval);

    for(int[] interval:intervals)
    {
        if(newInterval[1]>interval[0]){
            newInterval[1]=Math.max(interval[1],newInterval[1]);
            System.out.println("newInterval[0] "+newInterval[0]+" newInterval[1]  "+newInterval[1]);
            System.out.println("interval[0] "+interval[0]+" interval[1]  "+interval[1]);
        }
        else
        {
            System.out.println("Entered in the else block.");
            newInterval=interval;
            lst.add(newInterval);
        }
    }
return lst;
}

public static void main(String[] args){
    int[][] intervals={{1,3},{2,4},{6,8},{9,10}};
    ArrayList<int[]> newIntervals= (ArrayList<int[]>) MergeIntervals(intervals);

    for (int[] newInterval : newIntervals) {
        System.out.println("Start: " + newInterval[0] + ", End: " + newInterval[1]);
    }

}

}
