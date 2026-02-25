// PROBLEM : Longest Subarray with Majority Greater than K

// SOLUTION :

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        int n = arr.length;
        int prefix = 0;
        int maxLen = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            
            // Transform into +1 and -1
            if (arr[i] > k)
                prefix += 1;
            else
                prefix -= 1;
            
            // If prefix > 0, whole subarray (0 to i) works
            if (prefix > 0) {
                maxLen = i + 1;
            } 
            else {
                // If (prefix - 1) seen before, we found valid subarray
                if (map.containsKey(prefix - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(prefix - 1));
                }
            }
            
            // Store first occurrence only
            map.putIfAbsent(prefix, i);
        }
        
        return maxLen;
    }
}
