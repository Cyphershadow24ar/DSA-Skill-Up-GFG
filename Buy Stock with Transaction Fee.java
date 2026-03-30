// PROBLEM : Buy Stock with Transaction Fee

// SOLUTION :

class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        if (n == 0) return 0;

        int hold = -arr[0]; // buying on first day
        int cash = 0;       // no stock in hand

        for (int i = 1; i < n; i++) {
            int prevCash = cash;

            // Sell stock today
            cash = Math.max(cash, hold + arr[i] - k);

            // Buy stock today
            hold = Math.max(hold, prevCash - arr[i]);
        }

        return cash;
    }
}
