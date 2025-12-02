// PROBLEM : Travelling Salesman Problem

// SOLUTION : 

class Solution {
public:
    int tsp(vector<vector<int>>& cost) {
        int n = cost.size();
        
        // EDGE CASE FIX: If there is only 1 city, cost is 0 (or cost[0][0])
        if (n == 1) return 0;
        
        int LIMIT = (1 << n); // Total number of subsets
        int INF = 1e9 + 7;
        
        // dp[mask][i] stores the min cost to visit the set of cities represented 
        // by 'mask', ending at city 'i'.
        // We use a local vector to guarantee a clean slate for every test case.
        vector<vector<int>> dp(LIMIT, vector<int>(n, INF));
        
        // Base Case: Starting at city 0
        // Mask is 1 (binary ...001), ending at city 0, cost is 0
        dp[1][0] = 0;
        
        // Iterate over all possible masks
        for (int mask = 1; mask < LIMIT; ++mask) {
            for (int curr = 0; curr < n; ++curr) {
                
                // If the current state is valid (reachable)
                if ((mask & (1 << curr)) && dp[mask][curr] != INF) {
                    
                    // Try moving to a 'next' unvisited city
                    for (int next = 0; next < n; ++next) {
                        
                        // Check if 'next' is NOT in the current mask
                        if (!(mask & (1 << next))) {
                            int nextMask = mask | (1 << next);
                            int newCost = dp[mask][curr] + cost[curr][next];
                            
                            // Update min cost for the new state
                            if (newCost < dp[nextMask][next]) {
                                dp[nextMask][next] = newCost;
                            }
                        }
                    }
                }
            }
        }
        
        // Final Step: Connect the end of the path back to the start (City 0)
        int finalMask = LIMIT - 1; // Mask where all cities are visited
        int min_cost = INF;
        
        // Try returning to city 0 from every other city 'i'
        for (int i = 1; i < n; ++i) {
            if (dp[finalMask][i] != INF) {
                min_cost = min(min_cost, dp[finalMask][i] + cost[i][0]);
            }
        }
        
        return min_cost;
    }
};
