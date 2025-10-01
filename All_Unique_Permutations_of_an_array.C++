/* PROBLEM : All Unique Permutations of an array

Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array in sorted order.
Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Examples:

Input: arr[] = [1, 3, 3]
Output: [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
Explanation: These are the only possible distinct permutations for the given array.

Input: arr[] = [2, 3]
Output: [[2, 3], [3, 2]]
Explanation: These are the only possible distinct permutations for the given array.

Constraints:
1 ≤ arr.size() ≤ 9
*/

// SOLUTON : 

class Solution {
public:
    vector<vector<int>> uniquePerms(vector<int>& arr) {
        sort(arr.begin(), arr.end()); // sort to handle duplicates & order
        vector<vector<int>> result;
        vector<int> current;
        vector<bool> used(arr.size(), false);

        backtrack(arr, result, current, used);
        return result;
    }

private:
    void backtrack(vector<int>& arr, vector<vector<int>>& result,
                   vector<int>& current, vector<bool>& used) {
        if (current.size() == arr.size()) {
            result.push_back(current);
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            // Skip used element
            if (used[i]) continue;

            // Skip duplicates (only if previous identical element is not used)
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;

            used[i] = true;
            current.push_back(arr[i]);

            backtrack(arr, result, current, used);

            current.pop_back();
            used[i] = false;
        }
    }
};

