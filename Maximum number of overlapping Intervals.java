// PROBLEM : Maximum number of overlapping Intervals

// SOLUTION :

import java.util.*;

class Solution {
    public static int overlapInt(int[][] arr) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Step 1: Mark start and end+1
        for(int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        // Step 2: Prefix sum
        int curr = 0;
        int maxOverlap = 0;

        for(int val : map.values()) {
            curr += val;
            maxOverlap = Math.max(maxOverlap, curr);
        }

        return maxOverlap;
    }
}
