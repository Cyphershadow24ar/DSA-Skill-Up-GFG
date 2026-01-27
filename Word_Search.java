// PROBLEM : Word Search

// SOLUTION :

class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Start DFS if the first character matches
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] mat, String word, int i, int j, int index) {
        // Base case: Found the whole word
        if (index == word.length()) {
            return true;
        }

        // Boundary and mismatch check
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited
        char temp = mat[i][j];
        mat[i][j] = '#';

        // Explore all 4 directions
        boolean found = dfs(mat, word, i + 1, j, index + 1) ||
                        dfs(mat, word, i - 1, j, index + 1) ||
                        dfs(mat, word, i, j + 1, index + 1) ||
                        dfs(mat, word, i, j - 1, index + 1);

        // Backtrack: Restore the cell
        mat[i][j] = temp;

        return found;
    }
}
