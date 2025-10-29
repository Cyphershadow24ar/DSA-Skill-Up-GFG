/* PROBLEM : Graph Diameter

You are given an undirected connected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and vertex v.
Find the diameter of the graph. The diameter of a graph (sometimes called the width) is the number of edges on the longest path between two vertices in the graph.

Note: Graph do not contains any cycle.

Examples :

Input: V = 6, E = 5, edges[][] = [[0, 1], [0, 4], [1, 3], [1, 2], [2, 5]]
Output: 4
Explanation: The longest path in the graph is from vertices 4 to vertices 5 (4 -> 0 -> 1 -> 2 -> 5).

Input: V = 7, E = 6, edges[][] = [[0, 2], [0, 4], [0, 3], [3, 1], [3, 5], [1, 6]]
Output: 4
Explanation: The longest path in the graph is from vertices 2 to vertices 6 (2 -> 0 -> 3 -> 1 -> 6).

Constraints:
2 ≤ V ≤  105
1 ≤ E ≤  V - 1
0 ≤ edges[i][0], edges[i][1] < V
*/

// SOLUTION :

class Solution {
public:
    // Helper function to perform BFS and return the farthest node & distance
    pair<int, int> bfs(int start, vector<vector<int>>& adj) {
        vector<int> dist(adj.size(), -1);
        queue<int> q;
        q.push(start);
        dist[start] = 0;

        int farNode = start;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            for (int nei : adj[node]) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[node] + 1;
                    q.push(nei);
                    if (dist[nei] > dist[farNode]) {
                        farNode = nei;
                    }
                }
            }
        }

        return {farNode, dist[farNode]};
    }

    int diameter(int V, vector<vector<int>>& edges) {
        // Build adjacency list
        vector<vector<int>> adj(V);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }

        // Step 1: BFS from any node (say 0) to find farthest node A
        auto [nodeA, _] = bfs(0, adj);

        // Step 2: BFS from A to find farthest node B and distance
        auto [nodeB, diameter] = bfs(nodeA, adj);

        return diameter;
    }
};
