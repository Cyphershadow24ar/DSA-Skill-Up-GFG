/* PROBLEM : Unique K-Number Sum

Given two integers n and k, the task is to find all valid combinations of k numbers that adds up to n based on the following conditions:

Only numbers from the range [1, 9] used.
Each number can only be used at most once.
Note: You can return the combinations in any order, the driver code will print them in sorted order.

Examples:

Input: n = 9, k = 3
Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
Explanation: There are three valid combinations of 3 numbers that sum to 9: [1 ,2, 6], [1, 3, 5] and [2, 3, 4].

Input: n = 3, k = 3
Output: []
Explanation: It is not possible to pick 3 distinct numbers from 1 to 9 that sum to 3, so no valid combinations exist.

Constraints:
1 ≤ n ≤ 50
1 ≤ k ≤ 9
*/ 

// SOLUTION : 

class Solution {
  public:
    vector<vector<int>> ans;
    
    void backtrack(int start, int n, int k, vector<int>& path, int sum) {
        // base case: if we used k numbers and sum == n
        if (path.size() == k && sum == n) {
            ans.push_back(path);
            return;
        }
        if (path.size() > k || sum > n) return; // pruning
        
        for (int i = start; i <= 9; i++) {
            path.push_back(i);
            backtrack(i + 1, n, k, path, sum + i);
            path.pop_back(); // backtrack
        }
    }
    
    vector<vector<int>> combinationSum(int n, int k) {
        vector<int> path;
        backtrack(1, n, k, path, 0);
        return ans;
    }
};
