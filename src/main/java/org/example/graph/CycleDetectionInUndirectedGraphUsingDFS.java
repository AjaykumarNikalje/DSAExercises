package org.example.graph;

import java.util.*;

public class CycleDetectionInUndirectedGraphUsingDFS {

    private static Map<Integer, List<Integer>> adjacencyList=new HashMap<>();

    public static void addEdgeTOList(int start,int end)
    {
        adjacencyList.putIfAbsent(start,new ArrayList<>());
        adjacencyList.putIfAbsent(end,new ArrayList<>());
        adjacencyList.get(start).add(end);
        adjacencyList.get(end).add(start); // This step is only for undirected/ bidirectional graph.
    }

    public static boolean dfs(int cur,int parent, int[] visited){

        visited[cur]=1;
        boolean isCycle=false;
        for(int neighbour:adjacencyList.get(cur) ){

            if(visited[neighbour]==1 && neighbour!= parent)
            {
                return true;
            }

            if(visited[neighbour]==0){
            //else {
                 isCycle=dfs(neighbour,cur,visited);
                 if(isCycle)
                 { return true;}
            }
        }
        return isCycle;
    }

    public static boolean isCyclePresent(Map<Integer, List<Integer>> adjacencyList ,int[] visited)
    {

        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==0)
            {
                return dfs(i,-1,visited);
            }
        }

        return false;
    }

    public static void main(String[] args){
        int n=5;
        int[] visited=new int[n];
        int[][] edges={
                {0,1},
                {1,2},
                {2,0},
                {2,3},
                {3,4}
        };

        // Adding edges into the Adj. list.
        for(int[] edge:edges)
        {
            addEdgeTOList(edge[0],edge[1]);
        }

        System.out.println("Cycle is present in the graph: " +isCyclePresent( adjacencyList ,visited));


    }
}