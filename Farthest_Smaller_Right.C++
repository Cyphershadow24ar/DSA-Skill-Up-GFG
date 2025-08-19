/* PROBLEM :- Farthest Smaller Right

You are given an array arr[]. For each element at index i (0-based indexing), find the farthest index j to the right (i.e., j > i) such that arr[j] < arr[i].
If no such index exists for a given position, return -1 for that index. Return the resulting array of answers.

Examples:

Input: arr[] = [2, 5, 1, 3, 2]
Output: [2, 4, -1, 4, -1]
Explanation: arr[0] = 2: Farthest smaller element to the right is arr[2] = 1.
arr[1] = 5: Farthest smaller element to the right is arr[4] = 2.
arr[2] = 1: No smaller element to the right → -1.
arr[3] = 3: Farthest smaller element to the right is arr[4] = 2.
arr[4] = 2: No elements to the right → -1.

Input: arr[] = [2, 3, 5, 4, 1] 
Output: [4, 4, 4, 4, -1]
Explanation: arr[4] is the farthest smallest element to the right for arr[0], arr[1], arr[2] and arr[3].

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
*/

// SOLUTION :-

class Solution {
  public:
    vector<int> farMin(vector<int>& arr) {
        int n = arr.size();
        vector<int> ans(n, -1), suffixMin(n);
        
        // Step 1: Build suffix minimums
        suffixMin[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffixMin[i] = min(arr[i], suffixMin[i+1]);
        }

        // Step 2: For each index, binary search in suffixMin
        for (int i = 0; i < n; i++) {
            if (suffixMin[i] >= arr[i]) continue; // no smaller element exists
            
            int lo = i+1, hi = n-1, best = -1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (suffixMin[mid] < arr[i]) {
                    best = mid;   // possible answer
                    lo = mid + 1; // try farther right
                } else {
                    hi = mid - 1;
                }
            }
            ans[i] = best;
        }

        return ans;
    }
};
