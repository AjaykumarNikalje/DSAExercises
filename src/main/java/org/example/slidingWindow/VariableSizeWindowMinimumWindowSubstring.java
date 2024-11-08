package org.example.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.function.DoubleToIntFunction;

public class VariableSizeWindowMinimumWindowSubstring {

    public static void main(String[] args)
    {

        String str="ADOBECODEBANCABC";
        String pat="ABC";
        boolean isCharPresent=false;
        HashMap<Character,Integer> uniqueElements=new HashMap<>();
        Set<String> FinalSubStrings=new HashSet<>();

        for (int i = 0; i < pat.length(); i++) {
            char currentChar = pat.charAt(i);
            uniqueElements.compute(currentChar, (kk, v) -> (v == null) ? 1 : v + 1);
        }
        int count=uniqueElements.size();
        System.out.println(uniqueElements);
        System.out.println(count);

        int i=0;
        int j=0;
        int min= Integer.MAX_VALUE;
        String strWindow="";
        while(j<str.length())
        {
            char curChar=str.charAt(j);
            if(uniqueElements.containsKey(curChar))
            {
                uniqueElements.put(curChar,uniqueElements.get(curChar)-1);
                if(uniqueElements.get(curChar)==0)
                {
                    count--;
                }
            }

            if(count==0)
            {
                while(count==0)
                {
                    char OutOfWindowChar=str.charAt(i);

                    if(min > j-i+1 )
                    {
                        strWindow=str.substring(i,j+1);
                        min=Math.min(min,j-i+1);
                    }

                    if(uniqueElements.containsKey(OutOfWindowChar))
                    {
                        uniqueElements.put(OutOfWindowChar,uniqueElements.get(OutOfWindowChar)+1);

                        if(uniqueElements.get(OutOfWindowChar)>0)
                        {
                            count++;
                        }
                    }
                    i++;
                }
            }
            j++;

            System.out.println("count "+count);
            System.out.println("strWindow "+strWindow);
            System.out.println("min "+min);
        }
        //System.out.println("Largest window size with sum "+k+" "+max);
    }
}
