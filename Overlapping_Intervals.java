// PROBLEM : Overlapping Intervals

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        ArrayList<int[]> result = new ArrayList<>();
        
        // Edge case
        if (arr.length == 0) return result;
        
        // Step 1: Sort intervals by start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        // Step 2: Initialize first interval
        int start = arr[0][0];
        int end = arr[0][1];
        
        // Step 3: Merge intervals
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= end) {
                // Overlapping intervals → merge
                end = Math.max(end, arr[i][1]);
            } else {
                // No overlap → store previous interval
                result.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        
        // Add the last interval
        result.add(new int[]{start, end});
        
        return result;
    }
}
