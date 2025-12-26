// PROBLEM : Kth smallest element in a Matrix

// SOLUTION :

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        int ans = low;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countLessEqual(mat, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int countLessEqual(int[][] mat, int mid) {
        int n = mat.length;
        int row = 0, col = n - 1;
        int count = 0;

        while (row < n && col >= 0) {
            if (mat[row][col] <= mid) {
                count += (col + 1);
                row++;
            } else {
                col--;
            }
        }
        return count;
    }
}
