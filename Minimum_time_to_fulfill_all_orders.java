// PROBLEM : Minimum timne to fulfill all orders

// SOLUTION :

class Solution {
    public int minTime(int[] ranks, int n) {
        int m = ranks.length;
        int maxRank = 0;

        for (int r : ranks) {
            maxRank = Math.max(maxRank, r);
        }

        long low = 0;
        long high = (long) maxRank * n * (n + 1) / 2;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canMakeDonuts(ranks, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean canMakeDonuts(int[] ranks, int n, long time) {
        long total = 0;

        for (int r : ranks) {
            long t = 0;
            int k = 1;

            while (true) {
                t += (long) r * k;
                if (t > time) break;
                total++;
                k++;
                if (total >= n) return true;
            }
        }
        return total >= n;
    }
