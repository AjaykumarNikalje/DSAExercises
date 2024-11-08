package org.example;
import java.util.HashMap;
import java.util.Map;
public class CharacterReplacementTest {
    public static int CharReplaceString(String str,int limit){
        int size=str.length();
        int maxLen=0,maxFreq=0;
        int fp=0,sp=0;
        Map<Character,Integer> charCountMap=new HashMap<>();

        System.out.println("String size is "+size);
        while(sp<size) {
            char ch=str.charAt(sp);
            charCountMap.put(ch,charCountMap.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,charCountMap.get(ch));

            while(sp-fp+1-maxFreq >limit)
            {
                char ch2=str.charAt(fp);
                charCountMap.put(ch2,charCountMap.get(ch2)-1);
                fp++;
            }
            maxLen=Math.max(maxLen,sp-fp+1);
            sp++;
        }
        return maxLen;
    }
    public static void main(String[] args){
        String str="AAABBCCD";
        int k=2;
        System.out.println("The Maximum length can be "+CharReplaceString(str,k));

    }
}
