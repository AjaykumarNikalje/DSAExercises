package org.example.longestCommonSubsequence;

public class MinNumberOfDeletionInStringToMakePalindromeRecursion {

    public static int longestCommonSubsequence(String input1, String input2, int ip1Len,int ip2Len)
    {
        // base condition
        if(ip1Len<0 || ip2Len<0)
        {
            return 0;
        }

        if(input1.charAt(ip1Len)==input2.charAt(ip2Len)){
            return 1 + longestCommonSubsequence(input1,input2,ip1Len-1,ip2Len-1);
        }
        else {
            return Math.max(
                    longestCommonSubsequence(input1,input2,ip1Len-1,ip2Len)
                    ,
                    longestCommonSubsequence(input1,input2,ip1Len,ip2Len-1)
            );
        }
    }

    public static void main(String[] args){
        String input1="aebcbda";
        String input2=new StringBuilder(input1).reverse().toString();
        int m=input1.length();
        int n=input2.length();
        // output=2
        int output = m-longestCommonSubsequence(input1, input2, m-1, n-1);


        System.out.println("The minimum no of deletion needs to be done : " + output);

        input1="geeksforgeeks";
        input2=new StringBuilder(input1).reverse().toString();
        m=input1.length();
        n=input2.length();
        //output=8
        output = m-longestCommonSubsequence(input1, input2, m-1, n-1);
        System.out.println("The minimum no of deletion needs to be done : " + output);

    }
}
