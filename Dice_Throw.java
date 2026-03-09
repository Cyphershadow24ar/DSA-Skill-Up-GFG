// PROBLEM : Dice Throw

// SOLUTION :

class Solution {
    static long noOfWays(int m, int n, int x) {
        // dp[i][j] represents number of ways to get sum j using i dice
        long[][] dp = new long[n + 1][x + 1];

        // Base case: 0 dice can only form sum 0
        dp[0][0] = 1;

        // Iterate through the number of dice
        for (int i = 1; i <= n; i++) {
            // Iterate through each possible target sum
            for (int j = 1; j <= x; j++) {
                // To get sum j with i dice, the i-th die can be any face from 1 to m
                for (int k = 1; k <= m; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        return dp[n][x];
    }
}
