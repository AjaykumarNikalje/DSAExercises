package org.example.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NDigitNumbersIncreasingOrderTest {

    public static void generateNumbers(int n,int currentLength,int lastDigit,String currentString,List<String> finalResult){

        // base condition
        if(currentLength==n)
        {
            finalResult.add(currentString);
            return;
        }

        for(int i=lastDigit+1;i<=9;i++)
        {
            generateNumbers(n,currentLength+1,i,currentString+i,finalResult);
        }
    }

    public static List<String> generateNDigitNumbers(int n) {
        List<String> result = new ArrayList<>();

        if (n == 1) {
            // For n = 1, add digits 0 to 9 as single-digit numbers
            for (int i = 0; i <= 9; i++) {
                result.add(String.valueOf(i));
            }
        } else {
         generateNumbers(n,0,0,"",result);
        }
        return result;
    }

    public static void main(String[] args){
        int n = 2; // Example: generate 1-digit numbers, you can change n to test other cases
        List<String> result = generateNDigitNumbers(n);

        // Print all generated numbers
        for (String number : result) {
            System.out.println(number);
        }
    }

}
