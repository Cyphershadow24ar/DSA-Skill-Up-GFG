/* PROBLENM :- Count the Coprimes

You are given an array arr[] of positive integers. Your task is to count the number of pairs (i, j) such that:
0 ≤ i < j ≤ n-1
gcd(arr[i], arr[j]) = 1
In other words, count the number of unordered pairs of indices (i, j) where the elements at those positions are co-prime.

Examples:

Input: arr[] = [1, 2, 3]
Output: 3
Explanation: (0,1), (0,2), (1,2) are the pair of indices where gcd(arr[i], arr[j]) = 1

Input: arr[] = [4, 8, 3, 9]
Output: 4
Explanation: (0,2), (0,3), (1,2), (1,3) are the pair of indices where gcd(arr[i], arr[j]) = 1

Constraints:
2 ≤ arr.size() ≤ 104
1 ≤ arr[i] ≤ 10
*/

// SOLUTION :-


class Solution {
public:
    int cntCoprime(vector<int>& arr) {
        int n = arr.size();
        int maxVal = *max_element(arr.begin(), arr.end());

        vector<int> freq(maxVal + 1, 0);
        for (int x : arr) freq[x]++;

        vector<long long> countDiv(maxVal + 1, 0);
        // Count numbers divisible by d
        for (int d = 1; d <= maxVal; d++) {
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                countDiv[d] += freq[multiple];
            }
        }

        // Mobius-like inclusion-exclusion
        vector<long long> gcdPairs(maxVal + 1, 0);
        for (int d = maxVal; d >= 1; d--) {
            long long c = countDiv[d];
            if (c >= 2) {
                gcdPairs[d] = (c * (c - 1)) / 2; // pairs divisible by d
            }
            for (int multiple = 2 * d; multiple <= maxVal; multiple += d) {
                gcdPairs[d] -= gcdPairs[multiple];
            }
        }

        return (int)gcdPairs[1]; // pairs with gcd = 1
    }
};



