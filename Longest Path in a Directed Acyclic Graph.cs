// PROBLEM : Longest Path in a Directed Acyclic Graph

// SOLUTION : 

using System;
using System.Collections.Generic;

class Solution {
    public int[] maxDistance(int V, int src, List<List<int>> edges) {
        // Step 1: Build the Adjacency List
        List<List<int[]>> adj = new List<List<int[]>>();
        for (int i = 0; i < V; i++) {
            adj.Add(new List<int[]>());
        }

        foreach (var edge in edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].Add(new int[] { v, w });
        }

        // Step 2: Perform Topological Sort using DFS
        bool[] visited = new bool[V];
        Stack<int> stack = new Stack<int>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                TopologicalSortDFS(i, adj, visited, stack);
            }
        }

        // Step 3: Initialize distances with int.MinValue
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = int.MinValue;
        }
        dist[src] = 0;

        // Step 4: Relax edges in topological order
        while (stack.Count > 0) {
            int u = stack.Pop();

            if (dist[u] != int.MinValue) {
                foreach (var neighbor in adj[u]) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[u] + weight > dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        return dist;
    }

    private void TopologicalSortDFS(int u, List<List<int[]>> adj, bool[] visited, Stack<int> stack) {
        visited[u] = true;

        foreach (var neighbor in adj[u]) {
            int v = neighbor[0];
            if (!visited[v]) {
                TopologicalSortDFS(v, adj, visited, stack);
            }
        }

        stack.Push(u);
    }
}
