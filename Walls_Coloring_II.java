// PROBLEM : Walls Coloring II

// SOLUTION :

class Solution {
public:
    int minCost(vector<vector<int>> &costs) {
        int n = costs.size();
        if (n == 0) return 0;
        int k = costs[0].size();
        
        // Edge Case: If only 1 color is available and we have more than 1 wall,
        // it's impossible to avoid adjacent duplicates.
        if (k == 1) {
            return n == 1 ? costs[0][0] : -1;
        }

        // Previous row's minimums. 
        // Initialized to 0 so the first wall just takes its own costs.
        int prevMin1 = 0;
        int prevMin2 = 0;
        int prevMin1Idx = -1;

        for (int i = 0; i < n; ++i) {
            int currMin1 = INT_MAX;
            int currMin2 = INT_MAX;
            int currMin1Idx = -1;

            for (int j = 0; j < k; ++j) {
                int currentCost = costs[i][j];

                // Decision Logic:
                // If current color 'j' is different from the color that gave prevMin1,
                // we can extend the cheapest path. Otherwise, we must use the 2nd cheapest.
                if (j != prevMin1Idx) {
                    currentCost += prevMin1;
                } else {
                    currentCost += prevMin2;
                }

                // Update the Top 2 smallest costs for the CURRENT row
                if (currentCost < currMin1) {
                    currMin2 = currMin1;
                    currMin1 = currentCost;
                    currMin1Idx = j;
                } else if (currentCost < currMin2) {
                    currMin2 = currentCost;
                }
            }

            // Move current row values to previous for the next iteration
            prevMin1 = currMin1;
            prevMin2 = currMin2;
            prevMin1Idx = currMin1Idx;
        }

        // The answer is the cheapest cost found for the last wall
        return prevMin1;
    }
};
