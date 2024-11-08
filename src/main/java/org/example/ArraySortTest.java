package org.example;

import java.util.Arrays;

public class ArraySortTest {

    public static void insertElementInSortedOrder(int[] arr,int size,int last){

        //base condition
        if(size<=0 ){
            arr[size]=last;
            System.out.println("    insertRecursively size<=0 "+ size);
            System.out.println("    insertRecursively "+Arrays.toString(arr));
            return;
        }
        if(arr[size-1]<=last){
            arr[size]=last;
            System.out.println("    insertRecursively arr[size-1]<=last "+ size);
            System.out.println("    insertRecursively "+Arrays.toString(arr));
            return;
        }

        arr[size]=arr[size-1];
        System.out.println("    insertRecursively size "+ size);
        System.out.println("    insertRecursively The last value is "+ last);
        System.out.println("    insertRecursively arr[size-1] "+ arr[size-1]);
        System.out.println("    insertRecursively "+Arrays.toString(arr));
        //hypothesis
        insertElementInSortedOrder(arr,size-1,last);

    }
    public static void sortArray(int[] arr,int size){
        // base condition

        if(size<=1)
        {
            System.out.println("sortArray size<=1 "+ size);
            System.out.println("sortArray "+Arrays.toString(arr));
            return;
        }
        // hypothesis
        sortArray(arr,size-1);

        System.out.println("sortArray "+Arrays.toString(arr));
        // induction step
        int last=arr[size-1];
        System.out.println("sortArray The last value is "+ last);
        System.out.println("sortArray arr[size-1] "+ arr[size-1]);
        System.out.println("sortArray size "+ size);
        insertElementInSortedOrder(arr,size-1,last);

    }

    public static void main(String[] args){
        int[] arr={1,4,3,6,2};
        int size=arr.length;

        sortArray(arr,size);
       // System.out.println(Arrays.toString(arr));
    }
}
