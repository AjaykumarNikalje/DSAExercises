package org.example.recursion;

public class PermutationWithSpace {

    public static void permutationWithSpace(String ip,String op){

        if(ip.isEmpty())
        {
            System.out.println(op);
            return;
        }

        String op1=op;
        String op2=op;

        // hypothesis
        char temp=ip.charAt(0);
        String subInput=ip.substring(1);
        permutationWithSpace(subInput,op1+temp);

        permutationWithSpace(subInput,op2+" "+temp);


    }

    public static void main(String[] args){
        String ip="bc";
        String op="a";

        permutationWithSpace(ip,op);



    }
}
