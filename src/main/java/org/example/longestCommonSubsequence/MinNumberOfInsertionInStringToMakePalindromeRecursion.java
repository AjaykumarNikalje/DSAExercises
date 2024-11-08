package org.example.longestCommonSubsequence;

public class MinNumberOfInsertionInStringToMakePalindromeRecursion {

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
        String input1="zzazz";
        String input2=new StringBuilder(input1).reverse().toString();
        int m=input1.length();
        int n=input2.length();

        /*
        This problem is similar to the minimum number of the deletions to make the string palindrome.
        if s=mbadm
        then to make this string as palindrome, you need to delete is 2 (db). but, if we add ab at other places we don't need to remove the ab.
        mb(d)ad(b)m
        m(d)ba(b)dm.Hence, we can say if we add db we get the palindrome string.

        */

        // output=0
        int output = m-longestCommonSubsequence(input1, input2, m-1, n-1);


        System.out.println("The minimum no of insertion needs to be done : " + output);

        input1="mbadm";
        input2=new StringBuilder(input1).reverse().toString();
        m=input1.length();
        n=input2.length();
        //output=2
        output = m-longestCommonSubsequence(input1, input2, m-1, n-1);
        System.out.println("The minimum no of insertion needs to be done : " + output);

        input1="leetcode";
        input2=new StringBuilder(input1).reverse().toString();
        m=input1.length();
        n=input2.length();
        //output=5
        output = m-longestCommonSubsequence(input1, input2, m-1, n-1);
        System.out.println("The minimum no of insertion needs to be done : " + output);

    }
}
