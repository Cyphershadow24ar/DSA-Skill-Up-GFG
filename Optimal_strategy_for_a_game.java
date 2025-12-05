// PROBLEM : Optimal Strategy For A Game

// SOLUTION :

class Solution {
    public int maximumAmount(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Base case: single element
        for (int i = 0; i < n; i++)
            dp[i][i] = arr[i];

        // Base case: two elements
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);

        // For all lengths from 3 to n
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                // Choose left coin
                int pickLeft = arr[i] + Math.min(
                    (i + 2 <= j ? dp[i + 2][j] : 0),
                    (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0)
                );

                // Choose right coin
                int pickRight = arr[j] + Math.min(
                    (i <= j - 2 ? dp[i][j - 2] : 0),
                    (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0)
                );

                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[0][n - 1];
    }
}
