// PROBLEM : Rotten Oranges

// SOLUTION :

import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: initialize queue and count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges
        if (fresh == 0) return 0;

        int time = 0;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                for (int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2;
                        q.offer(new int[]{nx, ny});
                        fresh--;
                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) time++;
        }

        // Step 3: check remaining fresh
        return fresh == 0 ? time : -1;
    }
}
