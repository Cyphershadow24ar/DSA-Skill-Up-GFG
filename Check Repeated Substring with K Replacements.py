# PROBLEM : Check Repeated Substring with K Replacements

# SOLUTION :

from collections import Counter

class Solution:
    def kSubstr(self, s: str, k: int) -> bool:
        n = len(s)
        
        if n % k != 0:
            return False
        
        blocks = [s[i:i+k] for i in range(0, n, k)]
        mx = max(Counter(blocks).values())
        
        return mx >= len(blocks) - 1
