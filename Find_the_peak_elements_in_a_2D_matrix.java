// PROBLEM : Find the Peak Element in a 2D Matrix

// SOLUTION :

class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int left = 0, right = m - 1;

        while (left <= right) {
            int midCol = left + (right - left) / 2;

            // Find max element in mid column
            int maxRow = 0;
            for (int i = 0; i < n; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int midVal = mat[maxRow][midCol];
            int leftVal = (midCol - 1 >= 0) ? mat[maxRow][midCol - 1] : Integer.MIN_VALUE;
            int rightVal = (midCol + 1 < m) ? mat[maxRow][midCol + 1] : Integer.MIN_VALUE;

            // Peak condition
            if (midVal >= leftVal && midVal >= rightVal) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(maxRow);
                res.add(midCol);
                return res;
            }

            // Move towards larger neighbor
            if (leftVal > midVal) {
                right = midCol - 1;
            } else {
                left = midCol + 1;
            }
        }

        return new ArrayList<>(); // guaranteed to find a peak
    }
}
