# PROBLEM : Minimum Window subsequence

# SOLUTION :

class Solution:
    def minWindow(self, s1, s2):
        n, m = len(s1), len(s2)
        min_len = float('inf')
        start_index = -1
        
        i = 0  # Pointer for s1
        while i < n:
            j = 0  # Pointer for s2
            
            # 1. Forward scan: find the end of a valid subsequence
            while i < n:
                if s1[i] == s2[j]:
                    j += 1
                if j == m:
                    break
                i += 1
            
            # If we reached the end of s1 without finding all characters of s2
            if j < m:
                break
            
            # At this point, i is the index in s1 where the last char of s2 was found
            end = i
            
            # 2. Backward scan: find the best (latest) start for this window
            j = m - 1
            while i >= 0:
                if s1[i] == s2[j]:
                    j -= 1
                if j < 0:
                    break
                i -= 1
            
            # window_start is now i
            window_start = i
            current_len = end - window_start + 1
            
            # Update result if this window is smaller
            if current_len < min_len:
                min_len = current_len
                start_index = window_start
            
            # 3. Reset i to start searching for the NEXT potential window
            # We start from the character immediately after the current window's start
            i = window_start + 1
            
        return "" if start_index == -1 else s1[start_index:start_index + min_len]
