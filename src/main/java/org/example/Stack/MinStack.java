package org.example.Stack;
import java.util.Stack;

class MinStack {
    Stack<Long> s;
    long min;
    public MinStack() {
        s=new Stack<>();
    }

    public void push(int val) {

        if(s.size()==0)
        {
            s.push((long)val);
            min=(long)val;
        }
        else{
            if((long)val>=min){
                s.push((long)val);
            }
            else
            {
                s.push(2*(long)(val)-min);
                min=(long)val;
            }

        }

    }

    public void pop() {
        if(s.size()==0)
            return;
        else{
            if(s.peek()>=min){
                s.pop();
            }
            else{
                min=2*min-s.peek();
                s.pop();
            }

        }
    }

    public int top() {

        if(s.size()==0)
            return -1;
        else{
            long top=s.peek();
            if(s.peek()>=min)
                return (int)top;
            else{
                return (int)min;
            }
        }
    }

    public int getMin() {
        if(s.size()==0)
            return -1;
        return (int)min;
    }

    public static void main(String[] args)
    {
        MinStack ms=new MinStack();
        ms.push(10);
        ms.push(5);
        ms.push(3);
        System.out.println(ms.getMin());
    }
}

