// PROBLEM : Happiest Triplet

// SOLUITON :

import java.util.*;

class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        int x = 0, y = 0, z = 0;

        while (i < a.length && j < b.length && k < c.length) {

            int minVal = Math.min(a[i], Math.min(b[j], c[k]));
            int maxVal = Math.max(a[i], Math.max(b[j], c[k]));
            int diff = maxVal - minVal;
            int sum = a[i] + b[j] + c[k];

            if (diff < minDiff || (diff == minDiff && sum < minSum)) {
                minDiff = diff;
                minSum = sum;
                x = a[i];
                y = b[j];
                z = c[k];
            }

            // Move the pointer of the minimum element
            if (minVal == a[i]) i++;
            else if (minVal == b[j]) j++;
            else k++;
        }

        // Return in decreasing order
        int[] res = {x, y, z};
        Arrays.sort(res);
        return new int[]{res[2], res[1], res[0]};
    }
}
