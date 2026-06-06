// PROBLEM : Non-Attacking Black and White Knights

// SOLUTION :

class Solution:
    def numOfWays(self, n: int, m: int) -> int:
        # code here
      # MOD = 10**9 + 7
        
        t_s = n * m
        
        t_w = t_s * (t_s - 1)
        
        c2 = max(0, n - 1) * max(0, m - 2)
        c3 = max(0, n - 2) * max(0, m - 1)
        
        att_w = 4 * (c2 + c3)
        v_w = t_w - att_w
        
        return v_w
