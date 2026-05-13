// PROBLEM : Search for Subarray

// SOLUTION :

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> search(int[] a, int[] b) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.length;
        int m = b.length;

        // Step 1: Precompute the LPS array for pattern 'b'
        int[] lps = computeLPSArray(b);

        int i = 0; // index for a[]
        int j = 0; // index for b[]

        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }

            if (j == m) {
                // Found an occurrence! Add the starting index
                result.add(i - j);
                j = lps[j - 1]; // Look for the next potential match
            } else if (i < n && a[i] != b[j]) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Don't reset i, just move j based on LPS
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private int[] computeLPSArray(int[] b) {
        int m = b.length;
        int[] lps = new int[m];
        int len = 0; // length of the previous longest proper prefix suffix
        int i = 1;

        while (i < m) {
            if (b[i] == b[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
