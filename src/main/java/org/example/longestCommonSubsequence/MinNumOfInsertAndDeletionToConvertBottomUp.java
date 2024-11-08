package org.example.longestCommonSubsequence;


public class MinNumOfInsertAndDeletionToConvertBottomUp {

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

        String input1="geeksforgeeks";
        String input2="geeks";
        int m=input1.length();
        int n=input2.length();
        // output=9
        int output = longestCommonSubsequence(input1, input2, m, n);
        System.out.println("The No of inserts: " + (n-output));
        System.out.println("The No of deletes: " + (m-output));


        input1="geek";
        input2="eke";
        m=input1.length();
        n=input2.length();
        //output=5
        output = longestCommonSubsequence(input1, input2, m, n);
        System.out.println("The No of inserts: " + (n-output));
        System.out.println("The No of deletes: " + (m-output));

    }
}