package org.example.slidingWindow;

import java.util.HashMap;

public class VariableWindowSizePickToys {

    public static void main(String[] args)
    {

        String str="abaccab";
        int k=2;


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

            if(uniqueElements.size() < k)
            {
                j++;
            }
            else if(uniqueElements.size()==k)
            {
                max=Math.max((j-i+1),max);
                System.out.println("max "+max);
                j++;
            }
            else if(uniqueElements.size()>k )
            {
                while(uniqueElements.size()>k && i<j)
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
        System.out.println("John Can select maximum toys for "+k+" "+max);
    }
}
