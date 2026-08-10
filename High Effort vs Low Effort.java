 // PROBLEM : High Effort vs Low Effort

// SOLUTION :

class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
        int n = h.length;
        if (n == 0) return 0;
        if (n == 1) return Math.max(h[0], l[0]);

        // prev2 corresponds to dp[i-2], initialized for day 0
        int prev2 = Math.max(h[0], l[0]);
        
        // prev1 corresponds to dp[i-1], initialized for day 1
        int prev1 = Math.max(h[1], prev2 + l[1]);

        for (int i = 2; i < n; i++) {
            // Option 1: Do low effort today -> prev1 + l[i]
            // Option 2: Do high effort today -> prev2 + h[i]
            int current = Math.max(prev1 + l[i], prev2 + h[i]);
            
           
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
