// PROBLEM : Count Sorted Digit Groupings

// SOLUTION :

class Solution {
    int[][] dp;

    public int validGroups(String s) {
        int n = s.length();

        // Maximum possible sum = 9 * 100 = 900
        dp = new int[n][901];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 900; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, s);
    }

    private int solve(int idx, int prevSum, String s) {
        int n = s.length();

        // Reached end -> one valid grouping found
        if (idx == n) {
            return 1;
        }

        if (dp[idx][prevSum] != -1) {
            return dp[idx][prevSum];
        }

        int sum = 0;
        int ways = 0;

        // Try every possible substring starting at idx
        for (int i = idx; i < n; i++) {
            sum += s.charAt(i) - '0';

            // Non-decreasing condition
            if (sum >= prevSum) {
                ways += solve(i + 1, sum, s);
            }
        }

        return dp[idx][prevSum] = ways;
    }
}
