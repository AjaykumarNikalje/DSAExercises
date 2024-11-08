package org.example.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args)
    {
        int arr[] = { 1,3,2,4 };
        ArrayList<Integer> finalLst=new ArrayList();

        Stack<Integer> stk=new Stack<>();

        for(int i=0;i<arr.length;i++)
        {
            if(stk.empty())
            {
                finalLst.add(-1);
            }
            else if( stk.size()>0 && stk.peek()>arr[i] )
            {
                finalLst.add(stk.peek());
            }
            else if(stk.size()>0 && stk.peek()<=arr[i])
            {
                while(stk.size()>0 && stk.peek()<=arr[i])
                {
                    stk.pop();
                }

                if(stk.size()==0)
                {
                    finalLst.add(-1);
                }
                else
                {
                    finalLst.add(stk.peek());
                }
            }
            stk.add(arr[i]);
        }
        System.out.println(" The Final Array :" + Arrays.toString(finalLst.toArray()));
    }
}
