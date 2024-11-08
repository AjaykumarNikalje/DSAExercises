package org.example.Stack;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {
    public static int getMAH(int[] arr)
    {
        int[] left=new int[arr.length];
        Integer[] right=new Integer[arr.length];
        int[] size=new int[arr.length];
        int max= Integer.MIN_VALUE;

        Stack<Pair<Integer,Integer>> stk=new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            if(stk.empty())
            {
                left[i]=-1;
            }
            else if( stk.size()>0 && stk.peek().getKey()<arr[i] )
            {
                left[i]=stk.peek().getValue();
            }
            else if(stk.size()>0 && stk.peek().getKey()>=arr[i])
            {
                while(stk.size()>0 && stk.peek().getKey()>=arr[i])
                {
                    stk.pop();
                }

                if(stk.size()==0)
                {
                    left[i]=-1;
                }
                else
                {
                    left[i]=stk.peek().getValue();
                }
            }
            stk.add(new Pair(arr[i],i));
        }
        //System.out.println(" The  Array :" + Arrays.toString(arr ));
        //System.out.println(" The left Array :" + Arrays.toString(left ));

        stk.clear();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(stk.empty())
            {
                right[i]=arr.length;
            }
            else if( stk.size()>0 && stk.peek().getKey()<arr[i] )
            {
                right[i]=stk.peek().getValue();
            }
            else if(stk.size()>0 && stk.peek().getKey()>=arr[i])
            {
                while(stk.size()>0 && stk.peek().getKey()>=arr[i])
                {
                    stk.pop();
                }

                if(stk.size()==0)
                {
                    right[i]=arr.length;
                }
                else
                {
                    right[i]=stk.peek().getValue();
                }
            }
            stk.add(new Pair(arr[i],i));
        }
        //System.out.println(" The right Array :" + Arrays.toString(right ));

        for(int i=0;i<arr.length;i++) {
            int rightVal=0;
            int leftVal=0;

            rightVal=right[i];
            leftVal=left[i];
            size[i]=rightVal-leftVal-1;
            max=Math.max(max, (size[i] * arr[i]) );
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] arr={
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        int rowLength=arr.length;
        int colLength=arr[0].length;
        int max= Integer.MIN_VALUE;
        int[] histArr=arr[0];

        max=getMAH(histArr);

        for(int i=1;i<rowLength;i++){
           for(int j=0;j<colLength;j++)
           {
               if(arr[i][j]==0)
               {
                   histArr[j]=0;
               }
               else
               {
                   histArr[j]=arr[i][j]+histArr[j];
               }
           }
            System.out.println(Arrays.toString(histArr));
            max=Math.max(max,getMAH(histArr));
        }

        System.out.println("Max Area Rectangle in binary matrix : "+max);
    }
}
