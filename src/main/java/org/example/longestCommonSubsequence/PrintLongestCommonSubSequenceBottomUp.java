
package org.example.longestCommonSubsequence;

public class PrintLongestCommonSubSequenceBottomUp {

    public static String longestCommonSubsequence(String input1, String input2, int ip1Len,int ip2Len)
    {
        int LenRow=ip1Len;
        int LenCol=ip2Len;
        String[][] t=new String[ip1Len+1][ip2Len+1];

        System.out.println("LenRow "+LenRow +" LenCol "+LenCol);

        for(int i=0;i<=LenRow;i++)
        {
            t[i][0]="";
        }

        for(int j=0;j<=LenCol;j++)
        {
            t[0][j]="";
        }

        for (int i=1;i<=LenRow;i++){
            for (int j=1;j<=LenCol;j++) {

                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    t[i][j] =  t[i-1][j-1] + input1.charAt(i-1);
                } else {

                    String str1=t[i-1][j];
                    String str2=t[i][j-1];

                    if(str1.length()>str2.length())
                    {
                        t[i][j] = str1;
                    }
                    else {
                        t[i][j] = str2;
                    }
                }
            }
        }
        return t[ip1Len][ip2Len];
    }

    public static void main(String[] args){
        String input1="ABC";
        String input2="ACD";

        //AC
        String  output = longestCommonSubsequence(input1, input2, input1.length(), input2.length());
        System.out.println("Longest Common Subsequence " + output);


        String s1 = "zfadeg";
        String s2 = "cdfsdg";
        //fdg
        output = longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Subsequence " + output);


        s1 = "abd";
        s2 = "badc";
        //ad or bd
        output =longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Subsequence " + output);

        s1 = "abc";
        s2 = "";
        output = longestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println("Longest Common Subsequence " + output);
    }
}

