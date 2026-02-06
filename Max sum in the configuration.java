// PROBLEM : Max sum in the configuration

// SOLUTION :

class Solution {
    int maxSum(int[] arr) {
        int n = arr.length;

        int arrSum = 0;
        int currVal = 0;

        // Calculate sum of array and initial value of i*arr[i]
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }

        int maxVal = currVal;

        // Compute values for other rotations
        for (int i = 1; i < n; i++) {
            currVal = currVal + arrSum - n * arr[n - i];
            maxVal = Math.max(maxVal, currVal);
        }

        return maxVal;
    }
}
