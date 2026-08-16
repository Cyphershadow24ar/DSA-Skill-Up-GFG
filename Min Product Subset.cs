// PROBLEM : Min Product Subset

// SOLUTION : 

class Solution {
    public int minProd(int[] arr) {
        int n = arr.Length;
        if (n == 1) return arr[0];

        int mxn = int.MinValue;
        int mnp = int.MaxValue;
        int neg = 0, z = 0, p = 1;

        foreach (int x in arr) {
            if (x == 0) {
                z++;
                continue;
            }
            if (x < 0) {
                neg++;
                mxn = Math.Max(mxn, x);
            } else {
                mnp = Math.Min(mnp, x);
            }
            p *= x;
        }

        if (z == n || (neg == 0 && z > 0)) return 0;
        if (neg == 0) return mnp;
        if (neg % 2 == 0) p /= mxn;

        return p;
    }
}
