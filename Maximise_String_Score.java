// PROBLEM : Maximise String Score

// SOLUTION :

class Solution {
public:
    int maxScore(string &s, vector<vector<char>> &jumps) {
        int n = s.length();
        
        // 1. Setup allowed jumps matrix
        // allowed[u][v] is true if we can jump from char index u to v
        vector<vector<bool>> allowed(26, vector<bool>(26, false));
        for(auto &j : jumps) {
            allowed[j[0] - 'a'][j[1] - 'a'] = true;
        }
        // Rule: You can always jump from a char to the same char
        for(int i=0; i<26; i++) allowed[i][i] = true;

        // 2. State storage
        // max_val[source][target] stores the max value of:
        // (dp[prev] - PrefixSum[prev] + Count[target][prev] * ASCII(target))
        // We use a very small number to represent "unreachable"
        long long INF = -1e18;
        vector<vector<long long>> max_val(26, vector<long long>(26, INF));

        // Current prefix sum of ASCII values
        long long current_P = 0;
        // Current counts of each character encountered so far
        vector<long long> current_counts(26, 0);

        long long ans = 0;

        for (int i = 0; i < n; i++) {
            int u = s[i] - 'a'; // Current character index (0-25)
            long long dp_i = INF;

            // 3. Calculate dp[i] (Max score to reach current index)
            if (i == 0) {
                dp_i = 0;
            } else {
                // Check all possible previous characters (src) that could jump to current char (u)
                for (int src = 0; src < 26; src++) {
                    if (allowed[src][u]) {
                        long long prev = max_val[src][u];
                        if (prev != INF) {
                            // Reconstruct the score using current prefix sums
                            // score = prev_term + current_P - current_count_of_u * ascii_of_u
                            long long score = prev + current_P - current_counts[u] * s[i];
                            dp_i = max(dp_i, score);
                        }
                    }
                }
            }

            // 4. Update global answer and state table for future jumps
            if (dp_i != INF) {
                ans = max(ans, dp_i);

                // Now we are at 'u' with score dp_i. We become the "source" for future jumps.
                // We update max_val for ALL possible target characters 'v'
                for (int v = 0; v < 26; v++) {
                    // term = dp[i] - P[i] + count[v][i] * ascii(v)
                    // Note: current_counts[v] currently holds count EXCLUDING current position i for v != u,
                    // but logic requires count up to i-1. 
                    // Actually, at the start of loop i, current_counts holds data for 0...i-1. 
                    // This is exactly what we need for the formula derived.
                    
                    long long term = dp_i - current_P + current_counts[v] * (v + 'a');
                    max_val[u][v] = max(max_val[u][v], term);
                }
            }

            // 5. Update running prefix sums
            current_P += s[i];
            current_counts[u]++;
        }

        return (int)ans;
    }
};
