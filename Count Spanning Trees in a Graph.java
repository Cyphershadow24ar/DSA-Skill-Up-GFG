// PROBLEM : Count Spanning Trees in a Graph

// SOLUTION :

class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n <= 1) return 1;

        // 1. Build the Laplacian Matrix
        double[][] laplacian = new double[n][n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            laplacian[u][u]++;
            laplacian[v][v]++;
            laplacian[u][v]--;
            laplacian[v][u]--;
        }

        // 2. Create the reduced matrix (size n-1 x n-1)
        int size = n - 1;
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = laplacian[i][j];
            }
        }

        // 3. Calculate Determinant using Gaussian Elimination
        return (int) Math.round(calculateDeterminant(matrix, size));
    }

    private double calculateDeterminant(double[][] matrix, int n) {
        double det = 1.0;
        
        for (int i = 0; i < n; i++) {
            // Pivot selection
            int pivot = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[pivot][i])) {
                    pivot = j;
                }
            }
            
            // Swap rows
            if (pivot != i) {
                double[] temp = matrix[i];
                matrix[i] = matrix[pivot];
                matrix[pivot] = temp;
                det *= -1;
            }

            // If the diagonal is 0, the determinant is 0
            if (Math.abs(matrix[i][i]) < 1e-9) {
                return 0;
            }

            det *= matrix[i][i];

            // Eliminate lower rows
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i + 1; k < n; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }
        return Math.abs(det); 
    }
}
