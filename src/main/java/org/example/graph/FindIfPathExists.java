package org.example.graph;

import java.util.*;

public class FindIfPathExists {

    private static Map<Integer, List<Integer>> adjacencyList=new HashMap<>();

    public static boolean dfs(int cur,int end,Set visited){

        if(cur==end){
            return true;
        }
        visited.add(cur);

        for(int neighbour:adjacencyList.getOrDefault(cur,new ArrayList<>()) ){
          if(!visited.contains(neighbour) && dfs(neighbour,end,visited))
          {
              return true;
          }
        }
        return false;
    }
    public static boolean isPathExists(int src,int dest){
        if(adjacencyList.containsKey(src))
        {
            Set<Integer> visited=new HashSet<>();
            visited.add(src);
            return dfs( src, dest,visited);
        }
        else {
            return false;
        }
    }

    //Create Adj list
    public static void addEdgeTOList(int start,int end)
    {
        adjacencyList.putIfAbsent(start,new ArrayList<>());
        adjacencyList.putIfAbsent(end,new ArrayList<>());
        adjacencyList.get(start).add(end);
        //adjacencyList.get(end).add(start); // This step is only for undirected/ bidirectional graph.
    }

    public static void main(String[] args){
        int n=3;
        int[][] edges={
                {0,1},
                {1,2},
                {2,0},
                {2,3},
                {3,4}
               };
        int src=0;
        int dest=2;

        // Adding edges into the Adj. list.
        for(int i=0;i<5;i++)
        {
            addEdgeTOList(edges[i][0],edges[i][1]);
        }

        System.out.println("Does path exist for "+src+ " to "+dest+": " +isPathExists(src,dest));

         src=0;
         dest=3;
        System.out.println("Does path exist for "+src+ " to "+dest+": " +isPathExists(src,dest));
    }
}
