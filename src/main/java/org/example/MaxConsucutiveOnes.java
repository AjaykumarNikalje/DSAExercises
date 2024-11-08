package org.example;
import java.util.Arrays;

public class MaxConsucutiveOnes {
    public static void main(String[] args){
        int ans=0;
        int[] num=new int[]{1,1,1,0,0,1,1,1,1,1};
        int size=num.length;
        int count=0;
        for(int i=0;i<size;i++)
        {
            if(num[i]==0)
            {
                ans=Math.max(ans,count);
                count=0;
            }
            else {
                count++;
            }
        }
        ans=Math.max(ans,count);
        System.out.println(Arrays.toString(num)+ " Maximum Consecutive One: "+ ans);

    }
}
