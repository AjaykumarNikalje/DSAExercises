package org.example;

public class MajorElementVoting {

    public static int getMajorVotingElement(int[] arr){
        int count=0;
        int size=arr.length;

        int majorElement=arr[0];
        for(int i=1;i<size;i++){

            if(majorElement==arr[i]){
                count++;
            }
            else{
                count--;
                if(count==0){
                    majorElement=arr[i];
                    count++;
                }
            }
        }
        return majorElement;
    }

    public static void main(String[] args){
        int[] arr={1,1,2,2,2,4,4,4,4};

        System.out.println(getMajorVotingElement(arr));
    }
}
