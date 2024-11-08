package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithoutRepeat {

    public static void main(String[] args)
    {
        String str="abcabcbb";
        int fp=0,sp=0;
        Map<Character,Integer> cntMap=new HashMap<>();
        int ans=0,n=str.length();

        while(sp<n)
        {
           char c=str.charAt(sp);
           addToMap(cntMap,c);
           System.out.println("After addition: " +cntMap);
           while(fp<sp && !isValid(cntMap,c)){
               System.out.println("Inside inner while loop: "+ c);
               deleteFromMap(cntMap,c);
               System.out.println("After deletion: " +cntMap);
               fp++;
           }
           int length=sp-fp+1;
           ans=Math.max(length,ans);
           sp++;
           System.out.println("sp    :"+sp);
        }
    System.out.println("ans    :"+ans);
    }

    public static Boolean isValid(Map mp,char c){
        if((Integer) mp.getOrDefault(c, 0)>1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void deleteFromMap(Map mp,char c){
        mp.put(c, (Integer) mp.getOrDefault(c, 0) -1 );
    }

    public static void addToMap(Map mp,char c){
        System.out.println("c     :"+c);
        mp.put(c, (Integer) mp.getOrDefault(c, 0) + 1 );
    }

}
