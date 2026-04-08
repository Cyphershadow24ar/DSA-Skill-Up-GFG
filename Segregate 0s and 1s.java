// PROBLEM : Segregate 0s and 1s

// SOLUTION :

class Solution {
    void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Keep moving left pointer forward if it's already at a 0
            while (left < right && arr[left] == 0) {
                left++;
            }
            
            // Keep moving right pointer backward if it's already at a 1
            while (left < right && arr[right] == 1) {
                right--;
            }
            
            // If left < right, we found a 1 on the left and a 0 on the right. Swap them.
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}
