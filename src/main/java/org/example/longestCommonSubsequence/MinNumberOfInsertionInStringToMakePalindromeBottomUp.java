package org.example.longestCommonSubsequence;


public class MinNumberOfInsertionInStringToMakePalindromeBottomUp {

    public static int longestCommonSubsequence(String input1, String input2, int ip1Len,int ip2Len)
    {
        int LenRow=ip1Len;
        int LenCol=ip2Len;
        int[][] t=new int[ip1Len+1][ip2Len+1];

        System.out.println("LenRow "+LenRow +" LenCol "+LenCol);

        for(int i=0;i<=LenRow;i++)
        {
            t[i][0]=0;
        }

        for(int j=0;j<=LenCol;j++)
        {
            t[0][j]=0;
        }

        for (int i=1;i<=LenRow;i++){
            for (int j=1;j<=LenCol;j++) {

                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1] ;
                } else {
                    t[i][j] = Math.max(
                            t[i-1][j] ,
                            t[i][j-1]
                    );
                }
            }
        }
        return t[ip1Len][ip2Len];
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
        int output = m-longestCommonSubsequence(input1, input2, m, n);


        System.out.println("The minimum no of insertion needs to be done : " + output);

        input1="mbadm";
        input2=new StringBuilder(input1).reverse().toString();
        m=input1.length();
        n=input2.length();
        //output=2
        output = m-longestCommonSubsequence(input1, input2, m, n);
        System.out.println("The minimum no of insertion needs to be done : " + output);

        input1="leetcode";
        input2=new StringBuilder(input1).reverse().toString();
        m=input1.length();
        n=input2.length();
        //output=5
        output = m-longestCommonSubsequence(input1, input2, m, n);
        System.out.println("The minimum no of insertion needs to be done : " + output);

    }
}