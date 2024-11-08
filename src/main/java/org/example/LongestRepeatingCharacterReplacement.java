package org.example;
import java.util.HashMap;
import java.util.Map;
class LongestRepeatingCharacterReplacement {
    public static int CharacterReplacement(String s, int k) {
        int n=s.length();
        int maxlen=0,maxf=0;
        int fp=0,sp=0;
        Map<Character,Integer>map=new HashMap<>();

        while(sp<n){
            char ch=s.charAt(sp);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxf=Math.max(maxf,map.get(ch));

            while((sp-fp+1)-maxf>k){
                char ch2=s.charAt(fp);
                map.put(ch2,map.get(ch2)-1); //decrement the frequency
                fp++;
            }
            // if((j-i+1)+maxf<=k){
            maxlen=Math.max(maxlen,sp-fp+1);
            // }

            sp++;
        }
        return maxlen;
    }

    public static void main(String[] args)
    {
        String str="AAABBCCD";
        int k=2;
        System.out.println("The maximum length can be "+CharacterReplacement(str,k));
    }
}