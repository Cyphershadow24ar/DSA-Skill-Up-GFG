// PROBLEM : Min Edge Movements to Connect a Graph

// SOLUTION :

class Solution {
    // DSU Find operation with path compression
    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    int minEdgesReq(int n, int[][] edges) {
        int m = edges.length;
        
        // A graph with n vertices requires at least n - 1 edges to be connected
        if (m < n - 1) {
            return -1;
        }

        // Initialize DSU parent array
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        // Process each edge and perform union
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);

            // If they belong to different components, merge them
            if (rootU != rootV) {
                parent[rootU] = rootV;
                components--;
            }
        }

        // Minimum edge movements needed to connect 'components' components
        return components - 1;
    }
}
