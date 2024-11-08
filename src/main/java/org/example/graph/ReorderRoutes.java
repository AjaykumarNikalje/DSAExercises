package org.example.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutes {

    private static Map<Integer, List<int[]>> forwardAdjacencyList = new HashMap<>();

    public static void addEdgeTOList(int start, int end) {
        forwardAdjacencyList.putIfAbsent(start, new ArrayList<int[]>());
        forwardAdjacencyList.putIfAbsent(end, new ArrayList<int[]>());
        forwardAdjacencyList.get(start).add(new int[]{end, 1}); // 1 for original direction
        forwardAdjacencyList.get(end).add(new int[]{start, 0}); // 0 for reverse direction
    }

    public static int getMinOrder(Map<Integer, List<int[]>> forwardAdjacencyList, int city, int parent) {
        int count = 0; // Initialize count for this call
        for (int[] cur : forwardAdjacencyList.get(city)) {
            int next = cur[0];
            int dirValue = cur[1];
            if (next == parent) {
                continue; // Avoid going back to parent
            }
            count += dirValue; // Count if the edge needs to be reversed
            count += getMinOrder(forwardAdjacencyList, next, city); // Recursively add counts from children
        }
        return count; // Return the total count for this node
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5},
        };



        for (int[] connection : connections) {
            addEdgeTOList(connection[0], connection[1]);
        }

        int minChanges = getMinOrder(forwardAdjacencyList, 0, -1);
        System.out.println("The min order change required: " + minChanges);

        int[][] connections1 = {
                {1,0},
                {1,2},
                {3,2},
                {3,4}
        };

        n = 5;
        forwardAdjacencyList.clear();
        for (int[] connection : connections1) {
            addEdgeTOList(connection[0], connection[1]);
        }

        minChanges = getMinOrder(forwardAdjacencyList, 0, -1);
        System.out.println("The min order change required: " + minChanges);

    }
}
