// PROBLEM : Missing Element in Range

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // Step 1: Use a boolean array to track numbers present in arr
        // Size 100001 covers the max constraint of 10^5
        boolean[] present = new boolean[100006];
        
        for (int num : arr) {
            // Only mark if the number is within a reasonable bound
            if (num < present.length) {
                present[num] = true;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 2: Iterate through the range [low, high]
        for (int i = low; i <= high; i++) {
            // Step 3: If the number is NOT in the array, it's missing
            if (!present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}

