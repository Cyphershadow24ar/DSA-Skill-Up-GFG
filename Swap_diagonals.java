// PROBLEM : Swap diagonals

// SOLUTION :

class Solution {
    public void swapDiagonal(int[][] mat) {
        int n = mat.length; // Use .length for arrays
        
        for (int i = 0; i < n; i++) {
            // Java has no built-in swap for array indices, 
            // so we use a temporary variable
            int temp = mat[i][i];
            mat[i][i] = mat[i][n - 1 - i];
            mat[i][n - 1 - i] = temp;
        }
    }
}
