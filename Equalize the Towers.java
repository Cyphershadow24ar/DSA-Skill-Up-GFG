// PROBLEM : Equalize the Towers

// SOLUTION :

class Solution {
    public long minCost(int[] heights, int[] cost) {
        int low = 0;
        int high = 0;
        
        // Find the range for ternary search
        for (int h : heights) {
            high = Math.max(high, h);
        }
        
        long ans = calculateCost(heights, cost, low);
        
        while (low <= high) {
            int m1 = low + (high - low) / 3;
            int m2 = high - (high - low) / 3;
            
            long cost1 = calculateCost(heights, cost, m1);
            long cost2 = calculateCost(heights, cost, m2);
            
            ans = Math.min(ans, Math.min(cost1, cost2));
            
            if (cost1 < cost2) {
                high = m2 - 1;
            } else {
                low = m1 + 1;
            }
        }
        
        return ans;
    }
    
    // Helper function to calculate total cost for a specific target height
    private long calculateCost(int[] heights, int[] cost, int target) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (long) Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
}
