// PROBLEM : Negative Weight Cycle

// SOLUTION :

class Solution {
    public boolean isNegativeWeightCycle(int V, int[][] edges) {
        // Initialize distances to 0. This handles disconnected graphs seamlessly 
        // by acting as a universal starting point for all vertices.
        int[] dist = new int[V];
        
        // Step 1: Relax all edges up to V - 1 times
        for (int i = 0; i < V - 1; i++) {
            boolean updated = false;
            
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }
            
            // If no distance was updated in this pass, the graph has stabilized.
            // There's no need to continue looping.
            if (!updated) {
                break;
            }
        }
        
        // Step 2: Check for negative weight cycles
        // If an edge can still be relaxed after V-1 passes, a negative cycle exists.
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if (dist[u] + w < dist[v]) {
                return true;
            }
        }
        
        return false;
    }
}
