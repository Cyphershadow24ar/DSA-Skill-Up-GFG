/* PROBLEM :- Maximum sum Rectangle

Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the given matrix.

Examples:

Input: mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3], [-4, -1, 1, 7, -6]]
Output: 29
Explanation: The matrix is as follows and the green rectangle denotes the maximum sum rectangle which is equal to 29.

Input: mat[][] = [[-1, -2], [-3, -4]]
Output: -1
Explanation: Taking only the first cell is the optimal choice.

Constraints:
1 ≤ n, m ≤ 300
-1000 ≤ mat[i][j] ≤ 1000
*/

// SOLUTION :-

class Solution {
  public:
    // Helper function for Kadane's Algorithm
    int kadane(vector<int>& arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.size(); i++) {
            maxEndingHere = max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Main function to find maximum sum rectangle
    int maxRectSum(vector<vector<int>> &mat) {
        int n = mat.size();
        int m = mat[0].size();
        int maxSum = INT_MIN;

        for (int top = 0; top < n; top++) {
            vector<int> temp(m, 0);

            for (int bottom = top; bottom < n; bottom++) {
                for (int col = 0; col < m; col++) {
                    temp[col] += mat[bottom][col];
                }

                int currentMax = kadane(temp);
                maxSum = max(maxSum, currentMax);
            }
        }

        return maxSum;
    }
};
