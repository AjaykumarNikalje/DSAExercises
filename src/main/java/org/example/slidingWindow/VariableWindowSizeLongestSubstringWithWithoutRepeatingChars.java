package org.example.slidingWindow;

import java.util.HashMap;

public class VariableWindowSizeLongestSubstringWithWithoutRepeatingChars {

    public static void main(String[] args)
    {

        String str="bbbbb";

        int i=0;
        int j=0;
        int max= Integer.MIN_VALUE;
        HashMap<Character,Integer> uniqueElements=new HashMap();
        while(j<str.length())
        {
            char curChar=str.charAt(j);
            if(uniqueElements.containsKey(curChar))
            {
                uniqueElements.put(curChar,uniqueElements.get(curChar)+1);
            }
            else {
                uniqueElements.put(curChar,1);
            }

            if(uniqueElements.size() > j-i+1)
            {
                j++;
            }
            else if(uniqueElements.size()==j-i+1)
            {
                max=Math.max((j-i+1),max);
                System.out.println("max "+max);
                j++;
            }
            else if(uniqueElements.size() < j-i+1 )
            {
                while(uniqueElements.size() < j-i+1 && i<j)
                {
                    char OutOfWindowChar=str.charAt(i);
                    uniqueElements.put(OutOfWindowChar,uniqueElements.get(OutOfWindowChar)-1);
                    if(uniqueElements.get(OutOfWindowChar)==0)
                    {
                        uniqueElements.remove(OutOfWindowChar);
                    }
                    i++;
                }
                j++;
            }
        }
        System.out.println("Largest window size "+max);
    }
}
