package org.example.spaceComplexity;

import java.util.Arrays;

public class FindDuplicateAndMissingNumber {

    public static void main(String[] args)
    {
        int[] arr= {2,3,1,8,2,3,5,1};
        int n=arr.length;

        for(int i=0;i<n;i++)
        {
            int curNum=arr[i];

                if(curNum!=arr[curNum-1])
                {
                    arr[i]=arr[curNum-1];
                    arr[curNum-1]=curNum;
                }

        }

       /* int i =0;
        while(i < n){

            if (arr[i]!= arr[arr[i]-1]){

                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1]= temp;
            }
            else{
                i++;
            }
        }*/

        for(int i=0;i<n;i++)
        {
            if(arr[i]!=i+1)
            {
                System.out.println("Missing Number :"+ (i+1) );
                System.out.println("Duplicate Number :"+arr[i]);
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
