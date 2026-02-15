// PROBLEM: Chocolate Distribution Problem

// SOLUTION :

import java.util.*;

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // 1. Handle edge cases
        if (m == 0 || arr.size() == 0) return 0;
        
        // 2. Sort the array to bring similar values together
        Collections.sort(arr);
        
        int n = arr.size();
        
        // m students cannot get more packets than available
        if (n < m) return -1; 

        int minDiff = Integer.MAX_VALUE;

        // 3. Slide the window of size m
        // The window ends at index (i + m - 1)
        for (int i = 0; i <= n - m; i++) {
            int currentDiff = arr.get(i + m - 1) - arr.get(i);
            
            // 4. Update the global minimum difference
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        return minDiff;
    }
}
