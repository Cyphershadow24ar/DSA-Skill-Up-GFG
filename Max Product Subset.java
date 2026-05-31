// PROBLEM : Max Product Subset

// SOLUTION :

class Solution {
    public int findMaxProduct(int[] arr) {
        long mod = 1000000007L;

        int n = arr.length;
        if (n == 1) return arr[0];

        int neg = 0, zero = 0;
        int mxNeg = -11;
        long prod = 1;

        for (int x : arr) {
            if (x == 0) {
                zero++;
                continue;
            }

            if (x < 0) {
                neg++;
                mxNeg = Math.max(mxNeg, x);
            }

            prod = (prod * x) % mod;
        }

        if (zero == n) return 0;

        if (neg == 1 && neg + zero == n) return 0;

        if ((neg & 1) == 1) {
            long inv = pow((mxNeg % mod + mod) % mod, mod - 2, mod);
            prod = (prod * inv) % mod;
        }

        return (int)((prod + mod) % mod);
    }

    long pow(long a, long b, long mod) {
        long res = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }
}
