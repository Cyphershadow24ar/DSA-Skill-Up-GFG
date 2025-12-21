// PROBLEM : Count X in Range of a Sorted Array

// SOLUTION :

import java.util.*;

class Solution {

    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], x = q[2];

            int first = lowerBound(arr, l, r, x);
            int last  = upperBound(arr, l, r, x);

            result.add(last - first);
        }

        return result;
    }

    // First index where arr[i] >= x
    private int lowerBound(int[] arr, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // First index where arr[i] > x
    private int upperBound(int[] arr, int l, int r, int x) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
