/* PROBLEM : Replace O's with X's
Difficulty: MediumAccuracy: 34.0%Submissions: 129K+Points: 4Average Time: 20m
You are given a grid[][] of size n*m, where every element is either 'O' or 'X'. You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

Examples:

Input: 
grid[][] = [['X', 'X', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: We only changed those 'O' that are surrounded by 'X'
Input: 
grid[][] = [['X', 'O', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'O', 'X', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'O', 'O', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: There's no 'O' that's surround by 'X'.
Input: 
grid[][] = [['X', 'X', 'X'], 
          ['X', 'O', 'X'], 
          ['X', 'X', 'X']]
Output: 
[['X', 'X', 'X'], 
['X', 'X', 'X'], 
['X', 'X', 'X']]
Explanation: There's only one 'O' that's surround by 'X'.
Constraints:
1 ≤ grid.size() ≤ 100
1 ≤ grid[0].size() ≤ 100
*/


// SOLUTION :

class Solution {
  public:
    void dfs(int i, int j, vector<vector<char>>& grid, vector<vector<int>>& vis, int n, int m) {
        vis[i][j] = 1;
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        for(int k = 0; k < 4; k++) {
            int newRow = i + delRow[k];
            int newCol = j + delCol[k];
            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
               grid[newRow][newCol] == 'O' && !vis[newRow][newCol]) {
                dfs(newRow, newCol, grid, vis, n, m);
            }
        }
    }

    void fill(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> vis(n, vector<int>(m, 0));

        // Step 1: Mark 'O's connected to boundary as safe
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 'O' && !vis[i][j]) {
                    dfs(i, j, grid, vis, n, m);
                }
            }
        }

        // Step 2: Convert unvisited 'O' to 'X'
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 'O' && !vis[i][j])
                    grid[i][j] = 'X';
            }
        }
    }
};
