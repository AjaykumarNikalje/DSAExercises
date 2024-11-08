package org.example.longestCommonSubsequence;

public class ShortestCommonSuperSequenceRecursion {

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
        String input1="AGGTAB";
        String input2="GXTXAYB";
        int m=input1.length();
        int n=input2.length();
        // output=9
        int output = longestCommonSubsequence(input1, input2, m-1, n-1);
        System.out.println("Shortest Common Supersequence Length " + ((m+n)-output));


        input1="geek";
        input2="eke";
        m=input1.length();
        n=input2.length();
        //output=5
        output = longestCommonSubsequence(input1, input2, m-1, n-1);
        System.out.println("Shortest Common Supersequence Length " + ((m+n)-output));

    }
}
