// PROBLME : 1s Surrounded by 0s

// SOLUTION :

class Solution {

    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int cntOnes(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        // Traverse boundary cells
        for (int i = 0; i < n; i++) {

            if (grid[i][0] == 1 && !vis[i][0]) {
                dfs(i, 0, grid, vis);
            }

            if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
                dfs(i, m - 1, grid, vis);
            }
        }

        for (int j = 0; j < m; j++) {

            if (grid[0][j] == 1 && !vis[0][j]) {
                dfs(0, j, grid, vis);
            }

            if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
                dfs(n - 1, j, grid, vis);
            }
        }

        int count = 0;

        // Count enclosed 1s
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, int[][] grid, boolean[][] vis) {

        vis[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && grid[nr][nc] == 1 && !vis[nr][nc]) {

                dfs(nr, nc, grid, vis);
            }
        }
    }
}
