/* PROBLEM :- Longest Periodic Proper Prefix

Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough times produces a string that starts with s.

Examples:

Input: s = "aaaaaa"
Output: 5
Explanation: Repeating the proper prefix "aaaaa" forms "aaaaaaaaaa...", which contains "aaaaa" as a prefix. No longer proper prefix satisfies this.

Input: s = "abcab"
Output: 3
Explanation: Repeating the proper prefix "abc" forms "abcabc., which contains "abcab" as a prefix. No longer proper prefix satisfies this.

Input: s = "ababd"
Output: -1
Explanation: No proper prefix satisfying the given condition.

Constraints:
1 ≤ s.size() ≤ 105
s consists of lowercase English alphabets
*/

// SOLUTION :-

class Solution {
  public:
    vector<int> zFunction(const string &s) {
        int n = s.size();
        vector<int> z(n, 0);
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r)
                z[i] = min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s[z[i]] == s[i + z[i]])
                z[i]++;
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    int getLongestPrefix(string &s) {
        int n = s.size();
        vector<int> z = zFunction(s);
        
        for (int len = n - 1; len >= 1; --len) {
            if (z[len] >= n - len)
                return len;
        }
        return -1;
    }
};

