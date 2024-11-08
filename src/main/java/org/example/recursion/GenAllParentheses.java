package org.example.recursion;

public class GenAllParentheses {

    public static void getAllParentheses(int open,int close,String op){

        //base condition
        if(open==0 && close==0)
        {
            System.out.println(op);
            return;
        }

        // hypothesis
        String op1=op;
        String op2=op;

        if (open==close)
        {

            getAllParentheses(open-1,close,op+"(" );
        }
        else if(open==0)
        {
            getAllParentheses(open,close-1,op+")" );
        }
        else
        {
            getAllParentheses(open-1,close,op1+"(" );
            getAllParentheses(open,close-1,op2+")");
        }
    }

    public static void main(String[] args){
        int n=3;
        int open=n;
        int close=n;
        String op="";
        getAllParentheses(open,close,op);
    }
}
