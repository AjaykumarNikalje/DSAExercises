package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class EncodeAndDecodeOfString {

    public static String encode(List<String> strs){
          StringBuilder encodedString=new StringBuilder();

          for(String str:strs){
              int i=0;
              while(i<str.length())
              {
                 if(str.charAt(i)=='/'){
                    encodedString.append("//");
                 }
                 else if(str.charAt(i)==';'){
                      encodedString.append("/;");
                  }
                 else {
                     encodedString.append(str.charAt(i));
                 }
                  i++;

              }
              encodedString.append(';');
          }
          return encodedString.toString();
    }

    public static List<String> decode(String str){
        StringBuilder decodedString=new StringBuilder();
        List<String> strs=new ArrayList<String>();
        int i=0;
        while(i<str.length())
            {
                if(str.charAt(i)=='/'){
                    decodedString.append(str.charAt(i+1));
                    i=i+2;
                }
                else if(str.charAt(i)==';'){
                    strs.add(decodedString.toString());
                    decodedString.setLength(0);
                    i++;
                }
                else{
                    decodedString.append(str.charAt(i));
                    i++;
                }
            }

        return strs;
    }

    public static void main(String[] args){
        String[] text=new String[]{"Hel;lo","Wor/ld."};
        System.out.println("The Given Array : "+ Arrays.toString(text));
        System.out.println("The Given List : "+ Arrays.asList(text));
        System.out.println("The Encode method call result: "+ encode(Arrays.asList(text)));
        System.out.println("The Decode method call result: "+ decode(encode(Arrays.asList(text))));


    }

}
