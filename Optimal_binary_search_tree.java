// PROBLEM : Optimal binary search tree

// SOLUTION :

#include <vector>
#include <climits>
#include <numeric>

using namespace std;

class Solution {
  public:
    int minCost(vector<int> &keys, vector<int> &freq) {
        int n = keys.size();
        
        // dp[i][j] stores the minimum cost of a BST formed by keys from index i to j
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        // Prefix sum array to quickly calculate sum of frequencies for a range
        vector<int> freqSum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            freqSum[i+1] = freqSum[i] + freq[i];
        }
        
        // Helper lambda to get sum of frequencies from index i to j
        auto getSum = [&](int i, int j) {
            return freqSum[j+1] - freqSum[i];
        };

        // Iterate over the length of the sub-array (chain length)
        for (int length = 1; length <= n; length++) {
            // Iterate over start index i
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // End index j
                
                dp[i][j] = INT_MAX;
                int sum = getSum(i, j); // Sum of frequencies for current range
                
                // Try making every key 'r' in the range [i, j] the root
                for (int r = i; r <= j; r++) {
                    // Cost = Sum of freq + Cost of Left Subtree + Cost of Right Subtree
                    // Note: 'sum' is added because pushing a subtree down by one level 
                    // increases the cost by the sum of frequencies of all nodes in that subtree.
                    
                    int val = sum;
                    
                    // Add cost of left subtree if it exists
                    if (r > i) val += dp[i][r-1];
                    
                    // Add cost of right subtree if it exists
                    if (r < j) val += dp[r+1][j];
                    
                    if (val < dp[i][j]) {
                        dp[i][j] = val;
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
};
