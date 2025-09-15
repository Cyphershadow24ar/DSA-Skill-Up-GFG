/* PROBLEM : String stack

You are given two strings pat and tar consisting of lowercase English characters. 
You can construct a new string s by performing any one of the following operation for each character in pat:

Append the character pat[i] to the string s.
Delete the last character of s (if s is empty do nothing).
After performing operations on every character of pat exactly once, your goal is to determine if it is possible to make the string s equal to string tar.

Examples:

Input: pat = "geuaek", tar = "geek"
Output: true
Explanation: Append the first three characters of pat to s, resulting in s = "geu". Delete the last character for 'a', leaving s = "ge". Then, append the last two characters 'e' and 'k' from pat to s, resulting in s = "geek", which matches tar.

Input: pat = "agiffghd", tar = "gfg"
Output: true
Explanation: Skip the first character 'a' in pat. Append 'g' and 'i' to s, resulting in s = "gi". Delete the last character for 'f', leaving s = "g". Append 'f', 'g', and 'h' to s, resulting in s = "gfgh". Finally, delete the last character for 'd', leaving s = "gfg", which matches tar.

Input: pat = "ufahs", tar = "aus"
Output: false
Explanation: It is impossible to construct the string tar from pat with the given operations.

Constraints:
1 ≤ pat.size(), tar.size() ≤ 105

SOLUTION 
*/

#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    bool stringStack(std::string &pat, std::string &tar) {
        int n = pat.size();
        int m = tar.size();

        if (m > n) {
            return false;
        }

        // Precompute positions of each character based on index parity.
        // pos_even['c'] stores indices i where pat[i] = 'c' and i is even.
        // pos_odd['c'] stores indices i where pat[i] = 'c' and i is odd.
        std::vector<int> pos_even[26];
        std::vector<int> pos_odd[26];

        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                pos_even[pat[i] - 'a'].push_back(i);
            } else {
                pos_odd[pat[i] - 'a'].push_back(i);
            }
        }

        // This represents the exclusive upper bound for our search in pat.
        // We match tar from right to left, and each matched character from pat
        // becomes the new upper bound for the next search.
        int pat_idx_bound = n;
        
        // Iterate through tar from right to left.
        for (int j = m - 1; j >= 0; --j) {
            char target_char = tar[j];
            int char_code = target_char - 'a';
            
            // We need to find a match for tar[j] at some index k < pat_idx_bound.
            // The number of "skipped" characters between the previous match (at pat_idx_bound)
            // and the current match (at k) is (pat_idx_bound - 1 - k).
            // This count must be even, which means (pat_idx_bound - 1) and k
            // must have the same parity.
            int required_parity = (pat_idx_bound - 1) & 1;

            std::vector<int>& candidate_indices = (required_parity == 0) ? pos_even[char_code] : pos_odd[char_code];

            // We want the rightmost possible match. We use binary search to find
            // the largest index in candidate_indices that is less than pat_idx_bound.
            // std::lower_bound finds the first element that is not less than pat_idx_bound.
            auto it = std::lower_bound(candidate_indices.begin(), candidate_indices.end(), pat_idx_bound);

            if (it == candidate_indices.begin()) {
                // This means all indices in the candidate list are >= pat_idx_bound,
                // so no valid match can be found.
                return false;
            }

            // The element just before `it` is the largest index < pat_idx_bound.
            it--;
            int match_idx = *it;

            // Update the bound for the next search.
            pat_idx_bound = match_idx;
        }

        return true;
    }
};
