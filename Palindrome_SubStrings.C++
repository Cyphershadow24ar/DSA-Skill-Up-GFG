/* PROBLEM :- Palindrome SubStrings

Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.
Note: A substring is palindromic if it reads the same forwards and backwards.

Examples:

Input: s = "abaab"
Output: 3
Explanation: All palindromic substrings (of length > 1) are: "aba", "aa", "baab".

Input: s = "aaa"
Output: 3
Explanation: All palindromic substrings (of length > 1) are: "aa", "aa", "aaa".

Input: s = "abbaeae"
Output: 4
Explanation: All palindromic substrings (of length > 1) are: "bb", "abba", "aea", "eae".

Constraints:
2 ≤ s.size() ≤ 5 * 103
s contains only lowercase english characters
*/

// SOLUTION :-

class Solution {
public:
    int countPS(string &s) {
        int n = s.size();
        int count = 0;
        
        // Helper lambda to expand from a center
        auto expand = [&](int left, int right) {
            int c = 0;
            while (left >= 0 && right < n && s[left] == s[right]) {
                if (right - left + 1 >= 2) // length >= 2
                    c++;
                left--;
                right++;
            }
            return c;
        };
        
        // Check each possible center
        for (int i = 0; i < n; i++) {
            count += expand(i, i);     // odd length
            count += expand(i, i + 1); // even length
        }
        
        return count;
    }
};
