package org.example.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakBackTracking {

    public static void solve(String input,String output,HashSet<String> dict)
    {
        System.out.println("Input length: "+input.length());

        // base condition
        if (input.length()==0)
        {
            System.out.println("Base condition is met: output: "+ output);

            return;
        }

        for(int i=0;i<input.length();i++){
            String left=input.substring(0,i+1);
            System.out.println("left: "+left);
                System.out.println("The final output is "+output);
            if(dict.contains(left)){
                String right=input.substring(i+1);
                solve(right,output +" "+left,dict);
            }
        }
    }
    public static void main(String[] args){
        HashSet dict=new HashSet();
        dict.add("cats");
        dict.add("cat");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        String output=new String();
        String input="catsanddog";
        solve(input,output,dict);

    }
}
