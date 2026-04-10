// PROBLEM :

// SOLUTION :
class Solution {
    public int countIncreasing(int[] arr) {
        int count = 0;
        int len = 1; // Length of the current strictly increasing sequence
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++; // Sequence grows
                // A sequence of length 'len' adds 'len - 1' new valid subarrays ending at index i
                count += (len - 1); 
            } else {
                len = 1; // Sequence breaks, reset length
            }
        }
        
        return count;
    }
}
