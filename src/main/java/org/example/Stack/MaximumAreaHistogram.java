package org.example.Stack;

import javafx.util.Pair;

import java.util.*;

public class MaximumAreaHistogram {

    public static void main(String[] args)
    {
        int arr[] = {3, 5, 1, 7, 5, 9};
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
        System.out.println(" The  Array :" + Arrays.toString(arr ));
        System.out.println(" The left Array :" + Arrays.toString(left ));

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
        System.out.println(" The right Array :" + Arrays.toString(right ));

        for(int i=0;i<arr.length;i++) {
            int rightVal=0;
            int leftVal=0;

            rightVal=right[i];
            leftVal=left[i];
            size[i]=rightVal-leftVal-1;
            max=Math.max(max, (size[i] * arr[i]) );
        }
        System.out.println("The largest area : "+Arrays.toString(size));
        System.out.println("The largest area : "+max);

    }
}
