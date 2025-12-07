// PROBLEM : Number of distinct subsequences

// SOLUTION :

class Solution {
    int distinctSubseq(String str) {
        int n = str.length();
        long M = 1000000007; // 10^9 + 7

        // dp[i] stores the number of distinct subsequences of str[0...i-1]
        long[] dp = new long[n + 1];

        // last_occurrence[c] stores the (1-based) index of the last time character c appeared.
        // Since indices are 1-based in dp, a 0 means it hasn't appeared yet.
        // Array size 26 for 'a' to 'z'.
        int[] last_occurrence = new int[26];

        // Base case: dp[0] = 1 (empty subsequence for empty string)
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            char current_char = str.charAt(i - 1);
            int char_index = current_char - 'a';

            // 1. Initial count: 2 * dp[i-1]
            // Subsequences of str[0...i-2] (dp[i-1])
            // PLUS subsequences formed by appending current_char to those (dp[i-1])
            dp[i] = (2 * dp[i - 1]) % M;

            // 2. Handle duplicates
            int j = last_occurrence[char_index]; // j is the DP index for the last occurrence's prefix

            if (j != 0) {
                // If current_char has appeared before:
                // Subtract the number of distinct subsequences of str[0...j-1] (dp[j-1])
                // which, when current_char is appended, would create duplicates.
                // The correct index to subtract is dp[j-1]. Since j is the 1-based index
                // of the *last occurrence*, the prefix length is j-1, so we subtract dp[j-1].
                // The dp array is 1-based for string length, so dp[j-1] corresponds to str[0...j-2].
                
                // Let's adjust the storage for last_occurrence: store the *length* of the prefix
                // *before* the last occurrence. If we store the index (i) of the last char, 
                // the prefix to be subtracted from is DP[index-1].
                
                // Correction based on common DP formulation:
                // j stores the DP index of the last character's position.
                // j = last_occurrence[char_index];
                
                // Number of duplicate subsequences to remove: dp[j-1]
                
                // Let's make j store the index *i* (1-based) where the character was last seen.
                // If we store i, then the number of subsequences *before* this last occurrence is dp[i-1].
                // This dp[i-1] is what we need to subtract.
                
                // Re-think: Let `prev_len` be the length of the string *before* the last occurrence of `current_char`.
                // `prev_len` is what `last_occurrence[char_index]` stores.
                
                // If we store the DP index *i* of the last occurrence, `j` holds that index.
                // The number of subsequences of the string *before* that last occurrence is `dp[j-1]`.
                long duplicates_to_subtract = dp[j - 1];
                
                dp[i] = (dp[i] - duplicates_to_subtract + M) % M;
            }

            // 3. Update the last occurrence index
            last_occurrence[char_index] = i;
        }

        // dp[n] is the result for the entire string str[0...n-1]
        return (int)dp[n];
    }
}
