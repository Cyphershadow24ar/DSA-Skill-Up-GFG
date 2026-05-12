// PROBLEM : Mother Vertex

// SOLUTION :

import java.util.*;

class Solution {

    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        vis[node] = true;

        for (int nei : adj.get(node)) {

            if (!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }

    public int findMotherVertex(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];

        int candidate = -1;

        // Find candidate
        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }

        // Verify candidate
        vis = new boolean[V];

        dfs(candidate, adj, vis);

        for (boolean x : vis) {

            if (!x) {
                return -1;
            }
        }

        // Find smallest mother vertex
        int ans = candidate;

        for (int i = 0; i < candidate; i++) {

            vis = new boolean[V];

            dfs(i, adj, vis);

            boolean ok = true;

            for (boolean x : vis) {

                if (!x) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
