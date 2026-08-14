// PROBLEM : Numbers Without d as Digit

// SOLUTION :

public class Solution {
    public int countWithout(int n, int d) {
        // Convert the number to a string to process it digit by digit
        string s = n.ToString();
        
        // C# 3D array initialization [index, is_tight, is_leading_zero]
        int[,,] dp = new int[s.Length, 2, 2];
        
        // Initialize DP table with -1
        for (int i = 0; i < s.Length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i, j, k] = -1;
                }
            }
        }
        
        // Start the recursion: index 0, bounded tightly by 'n', and leading zeros initialized to true (1)
        return Solve(s, d, 0, 1, 1, dp);
    }
    
    private int Solve(string s, int d, int idx, int tight, int leadingZero, int[,,] dp) {
        // Base case: If we have processed all digits
        if (idx == s.Length) {
            // A valid number must have at least one non-zero digit
            return leadingZero == 1 ? 0 : 1;
        }
        
        // Return precalculated result if already computed
        if (dp[idx, tight, leadingZero] != -1) {
            return dp[idx, tight, leadingZero];
        }
        
        // Establish the maximum bound for the current digit
        int limit = (tight == 1) ? (s[idx] - '0') : 9;
        int ans = 0;
        
        // Try placing all valid digits from 0 to 'limit'
        for (int digit = 0; digit <= limit; digit++) {
            // Check if the current digit equals the forbidden digit 'd'
            if (digit == d) {
                // EXCEPTION: If d == 0 and we are just placing a leading zero, it's allowed
                // (e.g., "005" is valid even if d = 0, because it's just the number 5)
                if (!(d == 0 && leadingZero == 1 && digit == 0)) {
                    continue; // Skip this digit selection
                }
            }
            
            // Re-evaluate boolean flags for the next recursive step
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            int newLeadingZero = (leadingZero == 1 && digit == 0) ? 1 : 0;
            
            // Add the recursive result
            ans += Solve(s, d, idx + 1, newTight, newLeadingZero, dp);
        }
        
        // Cache and return the result
        return dp[idx, tight, leadingZero] = ans;
    }
}
