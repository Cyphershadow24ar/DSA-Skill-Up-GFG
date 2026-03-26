// PROBLEM : Number of Ways to Arrive at Destination

// SOLUTION :

import java.util.*;

class Solution {
    public int countPaths(int V, int[][] edges) {

        // Step 1: Build graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        // Step 2: Dijkstra setup
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0}); // {distance, node}

        // Step 3: Dijkstra
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : adj.get(u)) {
                int v = nei[0];
                long newDist = d + nei[1];

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.add(new long[]{newDist, v});
                } 
                else if (newDist == dist[v]) {
                    ways[v] += ways[u];
                }
            }
        }

        return ways[V - 1];
    }
}
