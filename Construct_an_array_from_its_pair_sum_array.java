// PROBLEM : Construct an array from its pair-sum array

// SOLUTION :

class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        int m = arr.length;

        ArrayList<Integer> resList = new ArrayList<>();

        // If m = 1 → original array size n = 2
        if (m == 1) {
            // arr[0] = res[0] + res[1], choose res[0] = 1
            resList.add(1);
            resList.add(arr[0] - 1);
            return resList;
        }

        // Compute n from formula: m = n*(n-1)/2
        int n = (int)((1 + Math.sqrt(1 + 8 * (long)m)) / 2);

        int[] res = new int[n];

        long S1 = arr[0];         // res[0] + res[1]
        long S2 = arr[1];         // res[0] + res[2]
        long S3 = arr[n - 1];     // res[1] + res[2]  (Careful index)

        // First 3 elements using equations
        res[0] = (int)((S1 + S2 - S3) / 2);
        res[1] = (int)(S1 - res[0]);
        res[2] = (int)(S2 - res[0]);

        // Fill remaining elements
        int idx = 2;
        for (int i = 3; i < n; i++) {
            res[i] = arr[idx] - res[0];
            idx++;
        }

        // Convert to ArrayList
        for (int x : res) {
            resList.add(x);
        }

        return resList;
    }
}
