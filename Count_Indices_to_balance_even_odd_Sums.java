// PROBLEM : Count Indices to Balance Even and Odd Sums

// SOLUTION :

class Solution {
    public int cntWays(int[] arr) {
        int n = arr.length;

        int totalEven = 0, totalOdd = 0;

        // Step 1: Calculate total even and odd index sums
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                totalEven += arr[i];
            else
                totalOdd += arr[i];
        }

        int leftEven = 0, leftOdd = 0;
        int count = 0;

        // Step 2: Try removing each index
        for (int i = 0; i < n; i++) {
            // Remove current element
            if (i % 2 == 0)
                totalEven -= arr[i];
            else
                totalOdd -= arr[i];

            // After removal, parity flips for right side
            int newEven = leftEven + totalOdd;
            int newOdd = leftOdd + totalEven;

            if (newEven == newOdd)
                count++;

            // Add current element to left side
            if (i % 2 == 0)
                leftEven += arr[i];
            else
                leftOdd += arr[i];
        }

        return count;
    }
}
