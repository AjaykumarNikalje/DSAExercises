package org.example.recursion;

import java.util.Arrays;
import java.util.Stack;
import java.math.*;

public class DeleteMiddleElementOfStack {

    public static void deleteElement(Stack<Integer> stk,int stkSize){
        // base condition
        if( stk.size()== Math.ceil((double) stkSize /2 ) ){
            System.out.println(stkSize/2);
            System.out.println("Main "+ Arrays.toString(stk.toArray()));
            stk.pop();
            return;
        }

        // recursive call
        int lastElement=stk.pop();
        deleteElement(stk,stkSize);

        // induction step
        stk.push(lastElement);
        }


    public static void main(String[] args){
        Stack<Integer> stk=new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);

        int stkSize=stk.size();

        deleteElement(stk,stkSize);

        System.out.println("Main "+ Arrays.toString(stk.toArray()));
    }
}
