# PROBLEM : Binary Strings with Equal Sum of Two Halves

# SOLUTION :

class Solution:
    def computeValue(self, n):
        mod = 1000000007
        
        fact = [1] * (2 * n + 1)
        for i in range(1, 2 * n + 1):
            fact[i] = fact[i - 1] * i % mod
        
        den = fact[n] * fact[n] % mod
        return fact[2 * n] * pow(den, mod - 2, mod) % mod
