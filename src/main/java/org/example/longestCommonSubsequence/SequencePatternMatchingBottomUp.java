package org.example.longestCommonSubsequence;

public class SequencePatternMatchingBottomUp {

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
        String input1="abc";
        String input2="ahbgdc";

        boolean output;
        // output=true
        if(longestCommonSubsequence(input1, input2, input1.length(), input2.length())==input1.length())
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
        if(longestCommonSubsequence(input1, input2, input1.length(), input2.length())==input1.length())
        {
            output=true;
        }
        else {
            output=false;
        }
        System.out.println("Is Sequence Pattern Matches:  " + output);
    }
}