// PROBLEM :  Bus Conductor

// SOLUTION :

import java.util.Arrays;

class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        // 1. Sort both arrays
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        
        int totalMoves = 0;
        
        // 2. Use chairs.length to ensure we stay within bounds
        // For input of size 7, this runs from index 0 to 6.
        for (int i = 0; i < chairs.length; i++) {
            totalMoves += Math.abs(chairs[i] - passengers[i]);
        }
        
        return totalMoves;
    }
}
