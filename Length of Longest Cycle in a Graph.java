// PROBLEM : Length of Longest Cycle in a Graph

// SOLUTION :

class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        java.util.Arrays.fill(adj, -1);
        for (int[] edge : edges) {
            adj[edge[0]] = edge[1];
        }

        int maxCycleLen = -1;
        int[] visitedTime = new int[V]; 
        boolean[] isGlobalVisited = new boolean[V];
        
        int timer = 1; 

        for (int i = 0; i < V; i++) {
            if (isGlobalVisited[i]) continue;

            int curr = i;
            int startTime = timer;
            java.util.HashMap<Integer, Integer> pathMap = new java.util.HashMap<>();

            while (curr != -1 && !isGlobalVisited[curr]) {
                isGlobalVisited[curr] = true;
                pathMap.put(curr, timer++);
                
                int nextNode = adj[curr];
                
                if (nextNode != -1 && pathMap.containsKey(nextNode)) {
                    int cycleLen = timer - pathMap.get(nextNode);
                    maxCycleLen = Math.max(maxCycleLen, cycleLen);
                    break;
                }
                curr = nextNode;
            }
        }

        return maxCycleLen;
    }
}
