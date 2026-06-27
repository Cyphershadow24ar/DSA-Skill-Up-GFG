// PROBLEM : k Times Appearing Adjacent Two 1's

// SOLUTION : 

class Solution {
    public int countStrings(int n, int k) {

        int mod = 1000000007;

        long[][][] dp = new long[n + 1][2][k + 1];

        dp[1][0][0] = 1;
        dp[1][1][0] = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= k; j++) {

                // Last bit = 0

                dp[i + 1][0][j] =
                    (dp[i + 1][0][j] + dp[i][0][j]) % mod;

                dp[i + 1][1][j] =
                    (dp[i + 1][1][j] + dp[i][0][j]) % mod;

                // Last bit = 1

                dp[i + 1][0][j] =
                    (dp[i + 1][0][j] + dp[i][1][j]) % mod;

                if (j + 1 <= k) {
                    dp[i + 1][1][j + 1] =
                        (dp[i + 1][1][j + 1] + dp[i][1][j]) % mod;
                }
            }
        }

        return (int)((dp[n][0][k] + dp[n][1][k]) % mod);
    }
}
