// PROBLEM : Row with max 1s

// SOLUTION : 

// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        int maxOnes = 0;
        int resultRow = -1;

        for (int i = 0; i < n; i++) {
            int firstOneIndex = firstOne(arr[i], m);

            if (firstOneIndex != -1) {
                int countOnes = m - firstOneIndex;
                if (countOnes > maxOnes) {
                    maxOnes = countOnes;
                    resultRow = i;
                }
            }
        }
        return resultRow;
    }

    // Binary search to find first occurrence of 1 in a row
    private int firstOne(int[] row, int m) {
        int low = 0, high = m - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == 1) {
                ans = mid;
                high = mid - 1; // search left
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
