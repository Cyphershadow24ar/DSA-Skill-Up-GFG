/* PROBLEM :- Median in a row-wise sorted Matrix

Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.

Examples:

Input: mat[][] = [[1, 3, 5], 
                [2, 6, 9], 
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.

Input: mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.

Input: mat = [[3], [4], [8]]
Output: 4
Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.

Constraints:
1 ≤ n, m ≤ 400
1 ≤ mat[i][j] ≤ 2000
*/

// Solution :-

class Solution {
  public:
    int median(vector<vector<int>> &mat) {
        int n = mat.size(), m = mat[0].size();
        
        // Find min and max values in the matrix
        int low = INT_MAX, high = INT_MIN;
        for(int i = 0; i < n; i++) {
            low = min(low, mat[i][0]);       // first element of row
            high = max(high, mat[i][m-1]);  // last element of row
        }
        
        int desired = (n * m + 1) / 2;  // median position
        
        while(low < high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            
            // Count numbers <= mid in each row
            for(int i = 0; i < n; i++) {
                cnt += upper_bound(mat[i].begin(), mat[i].end(), mid) - mat[i].begin();
            }
            
            if(cnt < desired) low = mid + 1; // need bigger numbers
            else high = mid;                 // mid might be the answer
        }
        
        return low;
    }
};
