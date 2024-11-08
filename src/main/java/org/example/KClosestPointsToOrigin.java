package org.example;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static int dist(int[] point)
    {
        int a=point[0];
        int b=point[1];
    return ( a*a + b*b );
    }

    public static void main(String[] args)
    {
        int[][] points = {
                {1, 3},    // Distance = 10
                {-2, 2},   // Distance = 8
                {5, 8},    // Distance = 89
                {0, 1},    // Distance = 1
                {2, -2}    // Distance = 8
        };

        int k=3;

        Queue<int[]> que=new PriorityQueue<>((a,b)-> dist(b)-dist(a));

        for (int [] point:points) {
            que.add(point);
            if (que.size() > k) {
                que.poll();
            }
        }

        int[][] answer=new int[k][2];
        int i = 0;
        while(!que.isEmpty()){
            answer[i++] =que.poll();
        }
        System.out.println("Final answer: "+Arrays.deepToString(answer));
    }
}
