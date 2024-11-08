package org.example.longestCommonSubsequence;

public class SequencePatternMatchingRecursion {

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
        String input1="abc";
        String input2="ahbgdc";

        boolean output;
        // output=true
        if(longestCommonSubsequence(input1, input2, input1.length()-1, input2.length()-1)==input1.length())
        {
            output=true;
        }
        else {
            output=false;
        }
        System.out.println("Is Sequence Pattern Matches:  " + output);

        input1="axc";
        input2="ahbgdc";
        // output=false
        if(longestCommonSubsequence(input1, input2, input1.length()-1, input2.length()-1)==input1.length())
        {
            output=true;
        }
        else {
            output=false;
        }
        System.out.println("Is Sequence Pattern Matches:  " + output);

    }
}
