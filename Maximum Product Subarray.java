// PROBLEM : Maximum Product Subarray

// SOLUTION :

class Solution {
    int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // Initialize with the first element
        long max_so_far = arr[0];
        long min_so_far = arr[0];
        long result = arr[0];

        for (int i = 1; i < n; i++) {
            long current = arr[i];

            // If the current element is negative, max and min swap roles
            // when multiplied by a negative number.
            if (current < 0) {
                long temp = max_so_far;
                max_so_far = min_so_far;
                min_so_far = temp;
            }

            // Update max and min by comparing current element 
            // with the product of current and previous max/min
            max_so_far = Math.max(current, max_so_far * current);
            min_so_far = Math.min(current, min_so_far * current);

            // Update the global result
            result = Math.max(result, max_so_far);
        }

        return (int) result;
    }
}
