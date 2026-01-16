// PROBLEM : Minimum Number of Workers

// SOLUTION :

class Solution {
  public:
    int minMen(vector<int>& arr) {
        int n = arr.size();
        vector<pair<int,int>> intervals;

        // Step 1: Build intervals
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int l = max(0, i - arr[i]);
                int r = min(n - 1, i + arr[i]);
                intervals.push_back({l, r});
            }
        }

        sort(intervals.begin(), intervals.end());

        int curr = 0, ans = 0, i = 0;

        // Step 2: Greedy coverage
        while (curr < n) {
            int farthest = -1;

            while (i < intervals.size() && intervals[i].first <= curr) {
                farthest = max(farthest, intervals[i].second);
                i++;
            }

            // ❗ If no interval can cover current hour
            if (farthest < curr) return -1;

            ans++;
            curr = farthest + 1;
        }

        return ans;
    }
};
