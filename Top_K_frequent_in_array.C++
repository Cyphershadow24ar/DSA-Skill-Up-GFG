/* PROBLEM : Top K Frequent in Array

Given a non-empty integer array arr[]. Your task is to find and return the top k elements which have the highest frequency in the array.
Note: If two numbers have the same frequency, the larger number should be given the higher priority.

Examples:

Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
Output: [4, 1]
Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.

Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
Output: [5, 11, 7, 10]
Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1.

Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105
1 ≤ k ≤ no. of distinct elements

SOLUTION :
*/

#include <bits/stdc++.h>
using namespace std;

class Solution {
  public:
    vector<int> topKFreq(vector<int> &arr, int k) {
        unordered_map<int, int> freq; // Step 1: Count frequencies
        for (int num : arr)
            freq[num]++;
        
        vector<pair<int, int>> elements; // Step 2: Store (element, frequency)
        for (auto &p : freq)
            elements.push_back({p.first, p.second});
        
        // Step 3: Custom sort
        sort(elements.begin(), elements.end(), [](pair<int,int> &a, pair<int,int> &b) {
            if (a.second == b.second)
                return a.first > b.first; // Larger element first if same frequency
            return a.second > b.second;   // Higher frequency first
        });
        
        // Step 4: Take top K elements
        vector<int> result;
        for (int i = 0; i < k && i < elements.size(); i++)
            result.push_back(elements[i].first);
        
        return result;
    }
};


