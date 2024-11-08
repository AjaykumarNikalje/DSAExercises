package org.example.longestCommonSubsequence;

public class PrintLongestCommonSubSequenceRecursion {

    public static String longestCommonSubsequence(String input1, String input2, int ip1Len,int ip2Len)
    {
        // base condition
        if(ip1Len<0 || ip2Len<0)
        {
            return "";
        }

        if(input1.charAt(ip1Len)==input2.charAt(ip2Len)){
            return  longestCommonSubsequence(input1,input2,ip1Len-1,ip2Len-1)+ input1.charAt(ip1Len) ;
        }
        else {
            String str1=longestCommonSubsequence(input1,input2,ip1Len-1,ip2Len);
            String str2=longestCommonSubsequence(input1,input2,ip1Len,ip2Len-1);

              if(str1.length()>str2.length())
              {
                  return str1;
              }
              else {
                  return str2;
              }
        }
    }

    public static void main(String[] args){
        String input1="abccba";
        String input2="abddba";
        //abba
        String output = longestCommonSubsequence(input1, input2, input1.length()-1, input2.length()-1);
        System.out.println("Longest Common Subsequence " + output);



        String s1 = "zfadeg";
        String s2 = "cdfsdg";
        //fdg
        output = longestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("Longest Common Subsequence " + output);


        s1 = "abd";
        s2 = "badc";
        //ad or bd
        output =longestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("Longest Common Subsequence " + output);

        s1 = "abc";
        s2 = "";
        output = longestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("Longest Common Subsequence " + output);

    }
}
