# PROBLEM : Binary Searchable Count

# SOLUTION :

class Solution:
    def binarySearchable(self, arr):
        n = len(arr)
        c = 0
        st = [(0, n - 1, float('-inf'), float('inf'))]

        while st:
            l, r, lo, hi = st.pop()
            if l > r:
                continue

            m = (l + r) // 2

            if lo < arr[m] < hi:
                c += 1

            st.append((l, m - 1, lo, min(hi, arr[m])))
            st.append((m + 1, r, max(lo, arr[m]), hi))

        return c
