// PROBLEM : Toeplitz matrix

// SOLUTION :

class Solution {
    public boolean isToeplitz(int[][] mat) {
        // Get the dimensions of the matrix
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Start from row 1 and column 1
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // If the current element doesn't match its top-left neighbor, it's not Toeplitz
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        // If all checks pass, it is a Toeplitz matrix
        return true;
    }
}
