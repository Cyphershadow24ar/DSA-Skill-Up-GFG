// PROBLME : Substring with Max Zero-One Diff

// SOLUTION :

class Solution {
    int maxSubstring(String s) {
        // code here
        int maxSum = -1;
        int currSum = 0;

        for (char c : s.toCharArray()) {
            int val = (c == '0') ? 1 : -1;

            currSum = Math.max(val, currSum + val);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
