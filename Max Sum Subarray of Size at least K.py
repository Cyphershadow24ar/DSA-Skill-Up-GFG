#  PROBLEM : Max Sum Subarray of Size at least K

# SOLUTION :

class Solution:
    def maxSumWithK(self, arr: list[int], k: int) -> int:
        # code here
        ans = float('-inf')
        s, minv = 0, 0
        for i in range(0, len(arr)):
            arr[i] += s
            s = arr[i]
            if i >= k:
                minv = min(arr[i-k], minv)
            if i >= k-1:
                ans = max(ans, arr[i] - minv)
        return ans
