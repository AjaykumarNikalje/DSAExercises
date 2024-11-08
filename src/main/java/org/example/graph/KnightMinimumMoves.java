package org.example.graph;
import java.util.LinkedList;
import java.util.Queue;
public class KnightMinimumMoves {

    public static int[][] possibleMoves={
            {2,1},{2,-1},{-2,1},{-2,-1},
            {1,2},{1,-2},{-1,2},{-1,-2}
    };

    public static boolean isInsideBoard(int x,int y,int n)
    {
        return (x>=1 && x<=n && y>=1 && y<=n);
    };

    public static int bfs(int currentX,int currentY,int targetX,int targetY,int n){

        // if the current position matches with target position.
        if(currentX==targetX && currentY==targetY) return 0;

        //create the queue
        Queue<int[]> que=new LinkedList<>();

        //visited
        boolean[][] visited=new boolean[n+1][n+1];

        que.add( new int[]{currentX,currentY,0});
        visited[currentX][currentY]=true;

        while(!que.isEmpty())
        {
            int[] cur=que.poll();
            int curX=cur[0];
            int curY=cur[1];
            int moves=cur[2];

            for (int[] move:possibleMoves)
            {

                int newX=curX+move[0];
                int newY=curY+move[1];

                System.out.println("curX "+curX +" curY "+curY);
                System.out.println("move[0] "+move[0] +" move[1] "+move[1]);
                System.out.println("newX "+newX +" newY "+newY);
                if(isInsideBoard(newX,newY,n) && !visited[newX][newY]) {

                    if (newX == targetX && newY == targetY) {
                        return moves + 1;
                    }

                    que.add(new int[]{newX, newY, moves + 1});
                    visited[newX][newY] = true;
                }

            }
        }

    return -1;
    }

    public static void main(String[] args)
    {
        int n=6;
        int[] knightPos={4,5};
        int[] targetPos={1,1};

        System.out.println("Number of steps need to take to reach target "+bfs(knightPos[0],knightPos[1],targetPos[0],targetPos[1],n));

    }
}
