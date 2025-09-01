/* PROBLEM : Sum of Mode

Given an array arr[] of positive integers and an integer k. You have to find the sum of the modes of all the subarrays of size k.
Note: The mode of a subarray is the element that occurs with the highest frequency. 
If multiple elements have the same highest frequency, the smallest such element is considered the mode.

Examples:

Input: arr[] = [1, 2, 3, 2, 5, 2, 4, 4], k = 3
Output: 13
Explanation: The mode of each k size subarray is [1, 2, 2, 2, 2, 4] and sum of all modes is 13.

Input: arr[] = [1, 2, 1, 3, 5], k = 2
Output: 6
Explanation: The mode of each k size subarray is [1, 1, 1, 3] and sum of all modes is 6.

Constraints:
1 ≤ k ≤ arr.size() ≤105
1 ≤ arr[i] ≤ 105
*/

// SOLUTION :

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int sumOfModes(vector<int>& arr, int k) {
        int n = arr.size();
        unordered_map<int,int> freq;
        map<int,set<int>> buckets;
        int maxFreq = 0;
        long long ans = 0;

        auto add = [&](int x) {
            int f = freq[x];
            if(f > 0) {
                buckets[f].erase(x);
                if(buckets[f].empty()) buckets.erase(f);
            }
            freq[x]++;
            f++;
            buckets[f].insert(x);
            maxFreq = max(maxFreq, f);
        };

        auto remove = [&](int x) {
            int f = freq[x];
            buckets[f].erase(x);
            if(buckets[f].empty()) buckets.erase(f);
            freq[x]--;
            if(freq[x] > 0) {
                buckets[f-1].insert(x);
            }
            if(buckets.find(maxFreq) == buckets.end()) {
                maxFreq--;
            }
        };

        // first window
        for(int i=0; i<k; i++) add(arr[i]);
        ans += *buckets[maxFreq].begin();

        // slide
        for(int i=k; i<n; i++) {
            add(arr[i]);
            remove(arr[i-k]);
            ans += *buckets[maxFreq].begin();
        }
        return (int)ans;
    }
};

