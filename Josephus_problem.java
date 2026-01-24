// PROBLEM : Josephus problem

// SOLUTION :

class Solution {
    public int josephus(int n, int k) {
        // We use a helper function to handle the 0-indexed recursion
        return solve(n, k) + 1;
    }

    private int solve(int n, int k) {
        // Base case: only one person left
        if (n == 1) {
            return 0;
        }
        
        // Recursive step: (result of n-1 people + k) % current n
        return (solve(n - 1, k) + k) % n;
    }
}
