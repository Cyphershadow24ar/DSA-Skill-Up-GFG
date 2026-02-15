// PROBLEM : Meeting Rooms

// SOLUTION :

import java.util.Arrays;

class Solution {
    static boolean canAttend(int[][] arr) {
        // 1. Sort the meetings by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Iterate through the sorted meetings
        for (int i = 0; i < arr.length - 1; i++) {
            // If the current meeting's end time is greater than 
            // the next meeting's start time, there's an overlap.
            if (arr[i][1] > arr[i + 1][0]) {
                return false;
            }
        }

        // 3. If no overlaps are found, return true
        return true;
    }
}
