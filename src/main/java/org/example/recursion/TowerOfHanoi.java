package org.example.recursion;

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source,char destination, char temp)
    {
        // base condition
        if(n==1){
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        // hypothesis
        towerOfHanoi(n-1,source,temp,destination);
        System.out.println("Move the disk "+n+" from "+source+" to "+ destination);

        // induction
        towerOfHanoi(n-1,temp,destination,source);
    }
    public static void main(String[] args){

        int n=3;
        towerOfHanoi(n,'A','C','B');

    }
}
