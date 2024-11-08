package org.example;
import java.util.Arrays;
public class MoveZeros {

    public static int[] changeValue(int[] arr,int index1,int index2)
    {
        arr[index1]=arr[index2];
        return arr;
    }
    public static int[] getZeroMatrix(int[] arr)
    {
        int pointer=0;

        for (int i=1;i<arr.length;i++)
        {
            //System.out.println("getZeroMatrix arr[i] "+arr[i] +" And i "+i);
            //System.out.println("getZeroMatrix pointer "+pointer);
            if(arr[i]!=0)
             {
                 changeValue(arr,pointer,i);
                pointer++;
                //System.out.println("else arr[i] "+arr[i] +" And i "+i);
                //System.out.println("else pointer "+pointer);
            }
            System.out.println(" arr[i] "+arr[i] +" And i "+i +" pointer "+pointer);
            System.out.println("The array : "+Arrays.toString(arr));

        }

        for(int i=pointer;i<arr.length;i++)
        {
          arr[i]=0;
        }
        return arr;
    }
    public static void main(String[] args)
    {
        int[] arr={0,1,0,3,2,5,4,0,2,0};

        System.out.println("The final array : "+Arrays.toString(getZeroMatrix(arr)));
    }
}
