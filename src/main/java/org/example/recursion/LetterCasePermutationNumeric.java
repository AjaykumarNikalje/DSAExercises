package org.example.recursion;

public class LetterCasePermutationNumeric {

    public static void getLetCasePerNumberic(String ip,String op){

        // base condition
        if(ip.isEmpty())
        {
            System.out.println(op);
            return;
        }

        // hypothesis
        String op1=op;
        String op2=op;
        char first=ip.charAt(0);
        boolean isDigit=Character.isDigit(first);
        String subInput=ip.substring(1);

        if (isDigit)
        {
            getLetCasePerNumberic(subInput,op+first+"");
        }
        else {
            getLetCasePerNumberic(subInput,op1+ (first+"").toLowerCase() );
            getLetCasePerNumberic(subInput,op2+ (first+"").toUpperCase() );
        }
    }


    public static void main(String[] args){
        String ip="3z4";
        String op="";
        getLetCasePerNumberic(ip,op);
    }
}
