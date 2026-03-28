// PROBLEM : Articulation Point - II

// SOLUTOIN :

import java.util.*;

class Solution {
    
    static int timer;
    
    static void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low,
                    ArrayList<ArrayList<Integer>> adj, boolean[] isArticulation) {
        
        visited[u] = true;
        disc[u] = low[u] = timer++;
        int childCount = 0;
        
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            
            if (!visited[v]) {
                childCount++;
                dfs(v, u, visited, disc, low, adj, isArticulation);
                
                low[u] = Math.min(low[u], low[v]);
                
                // Case 2: Non-root articulation point
                if (parent != -1 && low[v] >= disc[u]) {
                    isArticulation[u] = true;
                }
            } else {
                // Back edge
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        
        // Case 1: Root articulation point
        if (parent == -1 && childCount > 1) {
            isArticulation[u] = true;
        }
    }
    
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isArticulation = new boolean[V];
        
        timer = 0;
        
        // Step 2: Handle disconnected graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, adj, isArticulation);
            }
        }
        
        // Step 3: Collect results
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isArticulation[i]) result.add(i);
        }
        
        // Step 4: If no articulation point
        if (result.size() == 0) {
            result.add(-1);
        }
        
        return result;
    }
}
