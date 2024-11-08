package org.example.recursion;

import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {

    public static void insertElement(Stack<Integer> stk, int last){
        // base case
        if(stk.empty())
        {
            stk.push(last);
            return;
        }

        //recursive case
        int temp=stk.pop();
        insertElement(stk,last);

        // induction step
        stk.push(temp);

    }

    public static void reverse(Stack<Integer> stk){
        //base case
        if(stk.empty())
        {
            return;
        }
        // recursive call
        int last=stk.pop();
        reverse(stk);

        // induction step
        insertElement(stk,last);
    }
    public static void main(String[] args){

        Stack<Integer> stk=new Stack<>();
        stk.push(3);
        stk.push(2);
        stk.push(1);
        stk.push(7);
        stk.push(6);

        reverse(stk);
        System.out.println(Arrays.toString(stk.toArray()));

    }
}
