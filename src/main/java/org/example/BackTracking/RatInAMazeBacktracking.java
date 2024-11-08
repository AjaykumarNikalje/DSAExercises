package org.example.BackTracking;

import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;


class Choices{
   String dir;
    int x;
    int y;
    public Choices(String dir,int x, int y)
    {
        this.dir=dir;
        this.x=x;
        this.y=y;
    }
}
public class RatInAMazeBacktracking {

    public static boolean isSolved(int x, int y, int len) {
        return x == (len - 1) && y == (len - 1);
    }

    public static boolean isValid(int x, int y, int len, int[][] arr) {
        return (x >= 0 && y >= 0 && x < len && y < len && arr[x][y] == 1);
    }

    public static void solve(int x,int y, int len,int[][] arr,String path,ArrayList<String> result,ArrayList<Choices> choiceList)
    {
        // base condition
        if(isSolved(x,y,len)){
            result.add(path);
            return;
        }



        for(Choices choice:choiceList){
            int newX =x+choice.x;
            int newY =y+choice.y;

            if(isValid(newX,newY,len,arr))
            {
                arr[x][y] = 0;
                solve(newX,newY,len,arr,path+choice.dir,result,choiceList);
                arr[x][y] = 1;
            }
        }

    }

    public static void main(String[] args){
        int[][] arr= {
                        {1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}
                     };
        int len=arr.length;
        ArrayList<Choices> choiceLst=new ArrayList<>();
        choiceLst.add(new Choices("D",1,0));
        choiceLst.add(new Choices("U",-1,0));
        choiceLst.add(new Choices("L",0,-1));
        choiceLst.add(new Choices("R",0,1));

        ArrayList<String> result=new ArrayList<>();

        solve(0,0,len,arr,"",result,choiceLst);

        for(String res:result){
            System.out.println(res);
        }

        if (result.isEmpty()) {
            System.out.println("No paths found.");
        }
    }

}
