package org.example;
import java.util.Arrays;
import java.util.Comparator;
public class MeetingRooms {

   public static Boolean isMeetingsValid(int[][] intervals){
       // sort the array on first element of sub-array.
       // check if last element of current array is less than first element of the next array
       //if it is true, then return false else true.
       int size=intervals.length;
       Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));

       for(int[] interval:intervals)
       {
           System.out.println(Arrays.toString(interval));
       }
       System.out.println("Before for loop:");
       for(int i=0;i<size-1;i++){
           System.out.println("Current array"+Arrays.toString(intervals[i]));
           System.out.println("Next array"+Arrays.toString(intervals[i+1]));

           if(intervals[i][1]>intervals[i+1][0])
           {
               return false;
           }
       }
       return true;
   }

    public static void main(String[] args){
        int[][] intervals={{1,1},{2,4},{6,8},{9,10}};
        System.out.println("The meetings are valid: "+isMeetingsValid(intervals));
    }
}
