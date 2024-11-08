package org.example.recursion;

public class PermutationWithChangingCase {

    public static void getPermutWithChangingCase(String ip,String op){

        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        String op1=op;
        String op2=op;
        char first=ip.charAt(0);
        String subInput=ip.substring(1);

        getPermutWithChangingCase(subInput,op1+(""+first).toUpperCase() );
        getPermutWithChangingCase(subInput,(op2+first)) ;
    }

    public static void main(String[] args){
        String ip="ABC".toLowerCase();
        String op="";

        getPermutWithChangingCase(ip,op);

    }
}
