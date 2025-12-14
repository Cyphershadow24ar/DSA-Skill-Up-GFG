// PROBLEM : 2D Submatrix Sum Queries

// SOLUTION :

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int N = mat.length;
        if (N == 0) return new ArrayList<>();
        int M = mat[0].length;
        if (M == 0) return new ArrayList<>();

        // 1. Create and populate the 2D Prefix Sum Array (PSA)
        // Use 'int' since the maximum possible sum (10^9) fits.
        int[][] P = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                // mat is 0-indexed, P is 1-indexed
                // Calculation: P[i][j] = mat[i-1][j-1] + P[i-1][j] + P[i][j-1] - P[i-1][j-1]
                P[i][j] = mat[i - 1][j - 1] + P[i - 1][j] + P[i][j - 1] - P[i - 1][j - 1];
            }
        }

        // 2. Process the queries
        ArrayList<Integer> results = new ArrayList<>();
        
        for (int[] query : queries) {
            // Coordinates from query (r1, c1) to (r2, c2) are 0-indexed
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            // 1-indexed P coordinates
            int p_r1 = r1;     // Top exclusion row index
            int p_c1 = c1;     // Left exclusion column index
            int p_r2 = r2 + 1; // Bottom inclusion row index
            int p_c2 = c2 + 1; // Right inclusion column index

            // Calculate sum using the Inclusion-Exclusion Principle (all values are now int)
            // Sum = P[r2+1][c2+1] - P[r1][c2+1] - P[r2+1][c1] + P[r1][c1]
            int totalSum = P[p_r2][p_c2] - P[p_r1][p_c2] - P[p_r2][p_c1] + P[p_r1][p_c1];
            
            results.add(totalSum);
        }

        return results;
    }
}
