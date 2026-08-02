# PROBLEM : Sequences where Adjacent Divide

# SOLUTION :

class Solution:
    def count(self, n: int, m: int) -> int:
        # Base case: for arrays of size 1, any number from 1 to m is valid.
        # dp[i] represents the number of valid sequences of the current length ending in i.
        dp = [1] * (m + 1)
        dp[0] = 0  # 0 is not used as elements are in range [1, m]
        
        # Build sequences length by length up to n
        for length in range(2, n + 1):
            next_dp = [0] * (m + 1)
            
            # For each possible current element
            for curr in range(1, m + 1):
                # Check against all valid previous elements
                for prev in range(1, m + 1):
                    # If they divide each other, we can append 'curr' to sequences ending in 'prev'
                    if curr % prev == 0 or prev % curr == 0:
                        next_dp[curr] += dp[prev]
                        
            dp = next_dp
            
        # The total valid arrays of length n will be the sum of all counts in our DP array
        return sum(dp)
