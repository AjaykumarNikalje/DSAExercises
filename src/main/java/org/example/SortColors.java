package org.example;
import java.util.Arrays;
public class SortColors {

    public static int[] swap(int[] arr,int index1,int index2)
    {
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        return arr;
    }

    public static int[] getSortedArray(int[] arr){
        int start=0;
        int end=arr.length-1;
        int middle=0;

        while(middle<=end)
        {
           switch (arr[middle])
           {
               case 0:
                   swap(arr,start,middle);
                   start++;
                   middle++;
                   break;
               case 1:
                   middle++;
                   break;
               case 2:
                   swap(arr,end,middle);
                   end--;
                   break;
           }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr={1,1,1,0,0,0,2,1,2,2,2};

        System.out.println("The updated array: "+Arrays.toString(getSortedArray(arr)));

    }
}
