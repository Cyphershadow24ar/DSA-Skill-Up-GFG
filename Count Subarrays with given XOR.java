// PROBLEM : Count Subarrays with given XOR

// SOLUTION :

import java.util.*;

class Solution {
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixXor = 0;
        long count = 0;
        
        // Base case: prefixXor 0 appears once
        map.put(0, 1);
        
        for (int i = 0; i < arr.length; i++) {
            
            prefixXor ^= arr[i];
            
            // We want prefixXor ^ k
            int target = prefixXor ^ k;
            
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            
            // Store current prefixXor
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        
        return count;
    }
}
