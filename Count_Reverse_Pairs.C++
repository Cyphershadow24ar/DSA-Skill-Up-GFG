/* PROBLEM :- Count Reverse Pairs

You are given an array arr[] of positive integers, find the count of reverse pairs. A pair of indices (i, j) is said to be a reverse pair if both the following conditions are met:

0 ≤ i < j < arr.size()
arr[i] > 2 * arr[j]

Examples:
Input: arr[] = [3, 2, 4, 5, 1, 20]
Output: 3
Explanation:
The Reverse pairs are 
(0, 4), arr[0] = 3, arr[4] = 1, 3 > 2*1 
(2, 4), arr[2] = 4, arr[4] = 1, 4 > 2*1 
(3, 4), arr[3] = 5, arr[4] = 1, 5 > 2*1 

Input: arr[] = [5, 4, 3, 2, 2]
Output: 2
Explanation:
The Reverse pairs are
(0, 3), arr[0] = 5, arr[3] = 2, 5 > 2*2
(0, 4), arr[0] = 5, arr[4] = 2, 5 > 2*2

Constraints:
1 ≤ arr.size() ≤ 5*104
1 ≤ arr[i] ≤ 109
*/

// SOLUTION :-

class Solution {
  public:
    int mergeAndCount(vector<int> &arr, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;

        // Count reverse pairs
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long long)arr[i] > 2LL * arr[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge step
        vector<int> temp;
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) temp.push_back(arr[left++]);
            else temp.push_back(arr[right++]);
        }
        while (left <= mid) temp.push_back(arr[left++]);
        while (right <= high) temp.push_back(arr[right++]);

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return count;
    }

    int mergeSort(vector<int> &arr, int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += mergeAndCount(arr, low, mid, high);
        return count;
    }

    int countRevPairs(vector<int> &arr) {
        return mergeSort(arr, 0, arr.size() - 1);
    }
};

