// PROBLEM : Maximize Number of 1's

// SOLUITON :

class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeros++;
            }

            // Shrink window if zero flips exceed k
            while (zeros > k) {
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
