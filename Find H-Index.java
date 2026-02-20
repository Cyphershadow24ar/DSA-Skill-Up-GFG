// PROBLEM : Find H-Index

// SOLUTION :

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;

        // bucket array
        int[] count = new int[n + 1];

        // Step 1: fill bucket
        for (int c : citations) {
            if (c >= n)
                count[n]++;
            else
                count[c]++;
        }

        // Step 2: traverse from high to low
        int papers = 0;

        for (int h = n; h >= 0; h--) {
            papers += count[h];

            if (papers >= h)
                return h;
        }

        return 0;
    }
}
