package org.example.BackTracking;
import java.util.*;

public class LetterCombsOfPhoneNumberBackTracking {


    public static void resolve(int idx, String digits, Map<Character, String> mapping, StringBuilder currStr,List<String> ans) {
        if (idx == digits.length()) {
            ans.add(currStr.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String letters = mapping.get(ch);
        for (char letter : letters.toCharArray()) {
            currStr.append(letter);
            resolve(idx + 1, digits, mapping, currStr,ans);
            currStr.deleteCharAt(currStr.length() - 1); // backtracking step
        }
    }

    public static void main(String[] args) {
        String digits="23";

        Map<Character, String> mapping = new HashMap<>();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");

        ArrayList<String> ans=new ArrayList<>();
        StringBuilder currStr = new StringBuilder();
        resolve(0, digits, mapping, currStr,ans);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
