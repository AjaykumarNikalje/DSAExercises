package org.example;
import java.util.Arrays;
public class ProductOfArrayExceptSelf {

    public static void main(String[] args)
    {
        int[] num=new int[] {1, 2, 3, 4};
        int size=num.length;
        int prefix=1,suffix=1;
        int[] ans=new int[size];
        int[] left=new int[size];
        int[] right=new int[size];

        System.out.println("size   :"+size);

        for (int i=0;i<size;i++) {
            left[i]=prefix;
            right[size-i-1]=suffix;

            prefix=prefix * num[i];
            suffix=suffix * num[size-i-1];
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }

    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));
    System.out.println(Arrays.toString(ans));

    }

}
