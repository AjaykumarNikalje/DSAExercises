package org.example.longestCommonSubsequence;

public class LongestCommonSubStringBottomUp {

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
                    t[i][j] = 0;
                }
            }
        }

    int max=0;
        for (int i=1;i<=LenRow;i++){
            for (int j=1;j<=LenCol;j++) {
                max = Math.max(t[i][j],max)  ;
            }
        }
        return max;
    }

    public static void main(String[] args){

        String s1 = "ABC";
        String s2 = "ACD";
        int output = longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Substring Length: " + output);

        s1 = "abcds1s2z";
        s2 = "s1s2zabcd";
        output = longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Substring Length: " + output);

        s1 = "abc";
        s2 = "";
        output = longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Substring Length: " + output);



    }
}