package org.example;
import java.util.Arrays;
import java.util.Stack;

public class StackDS {
    public static void main(String[] args){
        Stack<Integer> stk=new Stack<>();

        if(stk.empty()){
            System.out.println("Stack is empty.");
        }

        stk.push(5);
        stk.push(4);
        stk.push(3);
        stk.push(2);
        stk.push(1);

        System.out.println("The top element of the stack: "+stk.peek());
        System.out.println("The index of the item : "+stk.search(1) );
        System.out.println("The index of the item : "+stk.search(3) );

        stk.pop();
        System.out.println("The top element of the stack after first pop operation: "+stk.peek());

        System.out.println(Arrays.toString(stk.toArray()));
    }
}
