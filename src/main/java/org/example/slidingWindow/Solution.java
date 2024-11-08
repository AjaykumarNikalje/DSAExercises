package org.example.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
class Solution {
    public static String minWindow(String s, String t) {
        String ans="";

        int i=0,j=0;

        int min=Integer.MAX_VALUE;

        HashMap<Character, Integer> map=new HashMap<>();

        for(int k=0;k<t.length();k++)

        {

            char c=t.charAt(k);

            map.put(c,map.getOrDefault(c,0)+1);
        }
        int count=map.size();

        for(j= 0 ; j<s.length(); j++ )

        {
            char c=s.charAt(j);
            if(map.containsKey(c))

            {

                map.put(c,map.get(c)-1);

                if(map.get(c)==0)

                    count--;

            }

            if(count==0)

            {

                while(count==0)

                {

                    char c1=s.charAt(i);
                    if(min>j-i+1)

                    {

                        ans=s.substring(i,j+1);

                        min=Math.min(min,j-i+1);

                    }

                    if(map.containsKey(c1)){
                        map.put(c1,map.get(c1)+1);

                        if(map.get(c1)>0)
                            count++;
                    }
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(minWindow("ADOBECODEBANCABC", "ABC"));
    }
    }
