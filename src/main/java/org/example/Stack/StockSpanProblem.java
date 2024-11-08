package org.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javafx.util.Pair;

public class StockSpanProblem {
    public static void main(String[] args)
    {
        int arr[] = {100, 80, 60, 70, 60, 75, 85};
        int[] finalArr=new int[arr.length];

        Stack<Pair<Integer,Integer>> stk=new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            if(stk.empty())
            {
                finalArr[i]=-1;
            }
            else if( stk.size()>0 && stk.peek().getKey()>arr[i] )
            {
                finalArr[i]=stk.peek().getValue();
            }
            else if(stk.size()>0 && stk.peek().getKey()<=arr[i])
            {
                while(stk.size()>0 && stk.peek().getKey()<=arr[i])
                {
                    stk.pop();
                }

                if(stk.size()==0)
                {
                    finalArr[i]=-1;
                }
                else
                {
                    finalArr[i]=stk.peek().getValue();
                }
            }
            stk.add(new Pair(arr[i],i));
        }
        System.out.println(" The Final Array :" + Arrays.toString(finalArr ));
        for(int i=0;i<finalArr.length;i++)
        {
            finalArr[i]=i-finalArr[i];
        }

        System.out.println(" The Final Array :" + Arrays.toString(finalArr ));
    }
}
