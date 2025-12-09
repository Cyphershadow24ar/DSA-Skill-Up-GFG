// PROBLEM : Missing And Repeating

// SOLUTION :

class Solution {
public:
    vector<int> findTwoElement(vector<int>& arr) {
        int n = arr.size();
        int repeating = -1, missing = -1;

        // Step 1: Find repeating number
        for (int i = 0; i < n; i++) {
            int idx = abs(arr[i]) - 1;

            if (arr[idx] < 0)
                repeating = abs(arr[i]);   // visited twice
            else
                arr[idx] *= -1;            // mark visited
        }

        // Step 2: Find missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {              // never visited → missing
                missing = i + 1;
                break;
            }
        }

        return {repeating, missing};
    }
};
