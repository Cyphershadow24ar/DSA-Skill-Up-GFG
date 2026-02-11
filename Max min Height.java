// PROBLEM : Max min Height

// SOLUTION :

class Solution {
    public long maxMinHeight(int[] arr, int k, int w) {
        int n = arr.length;
        long low = 0;
        long high = 1000000000L + k; // Max initial height + total days
        long ans = 0;

        for (int x : arr) low = Math.min(low, x);

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(int[] arr, int k, int w, long target) {
        int n = arr.length;
        long[] diff = new long[n + 1];
        long currentWater = 0;
        long daysUsed = 0;

        for (int i = 0; i < n; i++) {
            currentWater += diff[i];
            long currentHeight = arr[i] + currentWater;

            if (currentHeight < target) {
                long needed = target - currentHeight;
                daysUsed += needed;
                
                if (daysUsed > k) return false;

                // Apply watering window starting at i and ending at i + w
                currentWater += needed;
                if (i + w < n) {
                    diff[i + w] -= needed;
                }
            }
        }
        return daysUsed <= k;
    }
}
