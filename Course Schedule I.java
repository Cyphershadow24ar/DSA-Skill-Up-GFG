// PROBLEM : Course Schedule I

// SOLUTION :

import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // 1. Build Adjacency List and In-Degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        int[] inDegree = new int[n];
        
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            // The edge is: prerequisite -> course
            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }

        // 2. Add all courses with 0 prerequisites to the Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 3. Process the courses
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 4. If we processed all nodes, no cycle exists
        return count == n;
    }
}
