# PROBLEM : Equalize All Prefix Sums

# SOLUTION :

class Solution:
    def optimalArray(self, arr):
        n = len(arr)

        pref = [0] * n
        pref[0] = arr[0]

        for i in range(1, n):
            pref[i] = pref[i - 1] + arr[i]

        ans = [0] * n

        for i in range(n):
            m = i // 2
            median = arr[m]

            left = median * (m + 1) - pref[m]
            right = (pref[i] - pref[m]) - median * (i - m)

            ans[i] = left + right

        return ans
