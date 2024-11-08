package org.example.BackTracking;

public class AllPalendromicPartitionBackTracking {

    public static void main(String[] args) {
        String input  = "madam";
        int recursionNo=0;
        solution(input, "",recursionNo);

    }

    private static void solution(String input, String asf,int recursionNo) {

        //System.out.println("The recursion stack frame : "+ recursionNo);

        if(input.length() == 0)
        {
            System.out.println("Output : "+ asf);
            return;
        }



        for(int i =0; i< input.length(); i++)
        {
            //System.out.println("The current for loop index : "+ i);
            //System.out.println("The current input : "+ input);
            String prefix = input.substring(0,i+1);
            String modified = input.substring(i+1);
            //System.out.println("prefix : "+ prefix);
            //System.out.println("modified : "+ modified);
            if(isPalindrome(prefix)) {
                solution(modified, asf + "("+prefix+") 	",recursionNo+1);
            }
        }

    }

    private static boolean isPalindrome(String prefix) {
        int i = 0;
        int j = prefix.length()-1;
        while(i< j)
        {
            if(prefix.charAt(i) != prefix.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}