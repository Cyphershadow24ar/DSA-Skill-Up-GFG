// PROBLEM :  Target Sum

// SOLUTION :

class Solution {
    public int totalWays(int[] arr, int target) {
        int n = arr.length;
        int sum = 0;
        
        // normal loop
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        // edge cases
        if (Math.abs(target) > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;
        
        int t = (sum + target) / 2;
        
        int[] dp = new int[t + 1];
        dp[0] = 1;
        
        // normal nested loops
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            for (int j = t; j >= x; j--) {
                dp[j] = dp[j] + dp[j - x];
            }
        }
        
        return dp[t];
    }
}
