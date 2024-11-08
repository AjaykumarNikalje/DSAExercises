package org.example.slidingWindow;

import java.util.HashMap;

public class CountOccurrencesOfAnagrams {

    public static void main(String[] args){
        String txt="forxxorfxdofr";
        String pat="for";
        int k=pat.length();
        HashMap<Character,Integer> patCountMap=new HashMap<>();
        int anagramCount=0;
        for (int i = 0; i < pat.length(); i++) {
            char currentChar = pat.charAt(i);
            patCountMap.compute(currentChar, (kk, v) -> (v == null) ? 1 : v + 1);
        }
        int count=patCountMap.size();
        System.out.println(patCountMap);
        System.out.println(count);

        int i=0;
        int j=0;
        while(j<txt.length())
        {
            if(j-i+1 < k)
            {
               char CurChar= txt.charAt(j);
               if(patCountMap.containsKey(CurChar)){
                   patCountMap.put(CurChar, patCountMap.get(CurChar) - 1);
                   if(patCountMap.get(CurChar)==0)
                   {
                       count--;
                   }
            }
            }
            else
            {
                char CurChar= txt.charAt(j);
                if(patCountMap.containsKey(CurChar)){
                    patCountMap.put(CurChar, patCountMap.get(CurChar) - 1);
                    if(patCountMap.get(CurChar)==0)
                    {
                        count--;
                    }
                }

                if(i>0){
                    char OutOfWindowChar=txt.charAt(i-1);
                    if(patCountMap.containsKey(OutOfWindowChar)) {
                        patCountMap.put(OutOfWindowChar, patCountMap.get(OutOfWindowChar) + 1);
                        if (patCountMap.get(OutOfWindowChar) == 0) {
                            count--;
                        }
                    }
                }
            if(count==0)
            {
                anagramCount++;
            }
                i++;
            }
            j++;
        }
        System.out.println("The anagrams total count: "+anagramCount);

    }
}
