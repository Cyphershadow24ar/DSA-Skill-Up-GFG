# PROBLEM : Subarrays with Sum in Range

# SOLUTION :

class Solution:
    def countSubarray(self, arr: list[int], l: int, r: int) -> int:
        # code here
        curr_max = left = curr_min = right = count = 0
        for i, a in enumerate(arr):
            curr_max += a
            while left < i and curr_max > r:
                curr_max -= arr[left]
                left += 1
            curr_min += a
            while right < i and (m := curr_min - arr[right]) >= l:
                curr_min = m
                right += 1
            if l <= curr_min <= r:
                count += right - left + 1
        return count
