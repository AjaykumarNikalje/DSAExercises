package org.example.recursion;

public class PrintNBitBinaryNumber {

    public static void printNBitBinNumb(int n,int one,int zero,String op){

        //base condition
        if(n==0)
        {
            System.out.println(op);
            return;
        }

        // hypothesis
        String op1=op;
        String op2=op;

        if (one==zero || (one==0 && zero==0 ))
        {
           printNBitBinNumb(n-1,one+1,zero,op+"1" );
        }
        else
        {
            printNBitBinNumb(n-1,one+1,zero,op1+"1" );
            printNBitBinNumb(n-1,one,zero+1,op1+"0" );
        }
    }

    public static void main(String[] args){
        int n=3;
        int one=0;
        int zero=0;
        String op="";
        printNBitBinNumb(n,one,zero,op);
    }
}
