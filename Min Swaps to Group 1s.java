// PROBLEM : Min Swaps to Group 1s

// SOLUTION :

class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;

        int k = 0;
        for (int v : arr) {
            if (v == 1) k++;
        }

        if (k == 0) return -1;

        int c = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == 1) c++;
        }

        int max = c;

        for (int i = k; i < n; i++) {
            if (arr[i] == 1) c++;
            if (arr[i - k] == 1) c--;

            if (c > max) max = c;
        }

        return k - max;
    }
}
