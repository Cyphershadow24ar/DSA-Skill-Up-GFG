// PROBLEM : Last Moment Before All Ants Fall Out

// SOLUTION :

class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int ans = 0;

        // Ants moving left
        for (int pos : left) {
            ans = Math.max(ans, pos);
        }

        // Ants moving right
        for (int pos : right) {
            ans = Math.max(ans, n - pos);
        }

        return ans;
    }
}
