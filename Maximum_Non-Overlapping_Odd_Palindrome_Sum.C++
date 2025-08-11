/*PROBLEM : Maximum Non-Overlapping Odd Palindrome Sum

Given a string s consisting of lowercase English letters, find the maximum possible sum of the lengths of any two non-empty and non-overlapping palindromic substrings of odd length.
Formally, choose any two substrings s[i...j] and s[k...l] such that 1 ≤ i ≤ j < k ≤ l ≤ s.size(), both substrings are palindromes of odd length, and they do not overlap. Return the maximum sum of their lengths.

Note: A palindrome is a string that reads the same forward and backward. A substring is a contiguous sequence of characters within the string.

Examples:

Input: s = "xyabacbcz"
Output: 6
Explanation: "aba" and "cbc" are non-overlapping odd-length palindromes. Their lengths are 3 and 3 which gives the sum as 6.

Input: s = "gfgforgeeks"
Output: 4
Explanation: "gfg" and "g" are non-overlapping odd-length palindromes. Their lengths are 3 and 1 which gives the sum as 4.

Constraints:
2 ≤ s.size() ≤ 105
*/

// SOLUTION :

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    int maxSum(string &s) {
        int n = s.size();
        if (n < 2) return 0;

        // Manacher (odd-length): d1[i] = radius (count of chars including center)
        vector<int> d1(n);
        int l = 0, r = -1;
        for (int i = 0; i < n; ++i) {
            int k = (i > r) ? 1 : min(d1[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && s[i - k] == s[i + k]) ++k;
            d1[i] = k;
            if (i + k - 1 > r) {
                l = i - k + 1; r = i + k - 1;
            }
        }

        // bestStart[L] = max odd-palindrome length that starts exactly at L
        // We compute for each center i its leftmost start A = i - d1[i] + 1.
        // For each L we take the rightmost center i with A <= L (prefix max of i at A),
        // and if that i >= L it covers L => length = 2*(i-L)+1.
        vector<int> maxIAtStart(n, -1);
        for (int i = 0; i < n; ++i) {
            int A = i - d1[i] + 1;
            if (A >= 0) maxIAtStart[A] = max(maxIAtStart[A], i);
        }
        vector<int> bestStart(n, 0);
        int curMaxI = -1;
        for (int L = 0; L < n; ++L) {
            curMaxI = max(curMaxI, maxIAtStart[L]);
            if (curMaxI >= L) bestStart[L] = 2 * (curMaxI - L) + 1;
        }

        // bestEnd[R] = max odd-palindrome length that ends exactly at R
        // Symmetric idea: for each center i compute B = i + d1[i] - 1.
        // For each R we take the leftmost center i with B >= R (suffix min of i at B),
        // and if that i <= R it covers R => length = 2*(R-i)+1.
        const int INF = 1e9;
        vector<int> minIAtEnd(n, INF);
        for (int i = 0; i < n; ++i) {
            int B = i + d1[i] - 1;
            if (B < n) minIAtEnd[B] = min(minIAtEnd[B], i);
        }
        vector<int> bestEnd(n, 0);
        int curMinI = INF;
        for (int R = n - 1; R >= 0; --R) {
            curMinI = min(curMinI, minIAtEnd[R]);
            if (curMinI <= R) bestEnd[R] = 2 * (R - curMinI) + 1;
        }

        // prefix/suffix maxima and final split
        vector<int> leftMax(n, 0), rightMax(n, 0);
        leftMax[0] = bestEnd[0];
        for (int i = 1; i < n; ++i) leftMax[i] = max(leftMax[i - 1], bestEnd[i]);
        rightMax[n - 1] = bestStart[n - 1];
        for (int i = n - 2; i >= 0; --i) rightMax[i] = max(rightMax[i + 1], bestStart[i]);

        int ans = 0;
        for (int i = 0; i + 1 < n; ++i) ans = max(ans, leftMax[i] + rightMax[i + 1]);
        return ans;
    }
};
