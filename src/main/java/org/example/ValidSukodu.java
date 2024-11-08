package org.example;

import java.util.HashSet;

public class ValidSukodu {

    public static Boolean isValid(int[][] num){
        HashSet<String> seen=new HashSet<>();
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                int cur_value=num[i][j];
                if(cur_value!=0){
                    if(!seen.add(cur_value+ " found in row "+i)
                            || !seen.add(cur_value+ " found in column "+j)
                            || !seen.add(cur_value+ " found in sub-box "+i/3+" and "+j/3 )) return false;
                }
            }
        }
        System.out.println(seen);
        return true;
    }

    public static void main(String[] args){

        int[][] sukodu={
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println("Is Sudoku valid: "+isValid(sukodu));

    }
}
