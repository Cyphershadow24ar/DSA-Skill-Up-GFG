// PROBLEM : Special Keyboard

// SOLUTION :

class Solution {
    public int optimalKeys(int n) {
        if (n <= 6) return n;  // Base case
        
        int[] dp = new int[n + 1];
        
        // For small values, just type 'A'
        for (int i = 0; i <= 6 && i <= n; i++) {
            dp[i] = i;
        }
        
        // DP transition
        for (int i = 7; i <= n; i++) {
            dp[i] = 0;
            // Try breaking at j (where we do Ctrl+A, Ctrl+C at step j)
            for (int j = i - 3; j >= 1; j--) {
                // After j steps, we can paste (i - j - 1) times
                int curr = dp[j] * (i - j - 1);
                dp[i] = Math.max(dp[i], curr);
            }
        }
        
        return dp[n];
    }
}



