// PROBLEM : Adventure in a Maze

// SOLUTION :

class Solution {
    public List<int> findWays(int[][] grid) {
        int n = grid.Length;
        const int MOD = 1000000007;

        long[,] ways = new long[n, n];
        int[,] best = new int[n, n];

        // -1 means the cell is unreachable
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                best[i, j] = -1;
            }
        }

        // Starting cell
        ways[0, 0] = 1;
        best[0, 0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                // From TOP
                if (i > 0 &&
                    (grid[i - 1][j] == 2 || grid[i - 1][j] == 3) &&
                    best[i - 1, j] != -1) {

                    ways[i, j] =
                        (ways[i, j] + ways[i - 1, j]) % MOD;

                    best[i, j] = Math.Max(
                        best[i, j],
                        best[i - 1, j] + grid[i][j]
                    );
                }

                // From LEFT
                if (j > 0 &&
                    (grid[i][j - 1] == 1 || grid[i][j - 1] == 3) &&
                    best[i, j - 1] != -1) {

                    ways[i, j] =
                        (ways[i, j] + ways[i, j - 1]) % MOD;

                    best[i, j] = Math.Max(
                        best[i, j],
                        best[i, j - 1] + grid[i][j]
                    );
                }
            }
        }

        // Exit is unreachable
        if (best[n - 1, n - 1] == -1) {
            return new List<int> { 0, 0 };
        }

        return new List<int> {
            (int)ways[n - 1, n - 1],
            best[n - 1, n - 1]
        };
    }
}
