// PROBLEM : Count Prefix-Balanced Binary Strings

// SOLUTOIN :

class Solution {
    static final int MOD = 1000000007;

    // Helper method to compute (base^exp) % MOD
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public int prefixStrings(int n) {
        long catalan = 1;

        for (int i = 1; i <= n; i++) {
            long numerator = (2L * (2L * i - 1)) % MOD;
            long denominator = modInverse(i + 1);
            
            catalan = (catalan * numerator) % MOD;
            catalan = (catalan * denominator) % MOD;
        }

        return (int) catalan;
    }
}
