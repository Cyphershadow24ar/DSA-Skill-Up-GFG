// PROBLME : Brackets in Matrix Chain Multiplication

// SOLUTION :

class Solution {
    // Helper function to recursively construct the string
    private String constructResult(int i, int j, int[][] bracket) {
        // Base case: if it's a single matrix, return its letter
        if (i == j) {
            return String.valueOf((char)('A' + i));
        }

        // Recursive step: ( LeftResult + RightResult )
        int k = bracket[i][j];
        return "(" + constructResult(i, k, bracket) + constructResult(k + 1, j, bracket) + ")";
    }

    public String matrixChainOrder(int arr[]) {
        int n = arr.length;      // Length of the dimension array
        int numMatrices = n - 1; // Actual number of matrices

        // dp[i][j] stores the minimum cost to multiply matrices i through j
        int[][] dp = new int[numMatrices][numMatrices];
        
        // bracket[i][j] stores the split index 'k' that gave the minimum cost
        int[][] bracket = new int[numMatrices][numMatrices];

        // Initialize DP table
        // We only need to process chain lengths from 2 to numMatrices
        // (Length 1 is cost 0, which is the default int value, so no loop needed)
        
        // len is the chain length
        for (int len = 2; len <= numMatrices; len++) {
            // i is the starting matrix index
            for (int i = 0; i < numMatrices - len + 1; i++) {
                int j = i + len - 1; // j is the ending matrix index
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible split point k between i and j
                for (int k = i; k < j; k++) {
                    // Cost = cost(left) + cost(right) + cost(multiplication)
                    // Dimensions:
                    // Matrix sequence i..k results in dim: arr[i] x arr[k+1]
                    // Matrix sequence k+1..j results in dim: arr[k+1] x arr[j+1]
                    int cost = dp[i][k] + dp[k+1][j] + (arr[i] * arr[k+1] * arr[j+1]);

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        bracket[i][j] = k; // Store the optimal split index
                    }
                }
            }
        }

        // Reconstruct the solution string covering all matrices (index 0 to numMatrices-1)
        return constructResult(0, numMatrices - 1, bracket);
    }
}
