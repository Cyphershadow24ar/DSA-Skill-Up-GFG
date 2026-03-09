// PROBLEM :  Pythagorean Triplet

// SOLUTION :

import java.util.ArrayList;

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // Since max value is 1000, use a boolean array for O(1) lookups
        boolean[] exists = new boolean[1001];
        int maxVal = 0;
        
        for (int x : arr) {
            exists[x] = true;
            if (x > maxVal) maxVal = x;
        }

        // Create a list of squares of the numbers that actually exist in arr
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= maxVal; i++) {
            if (exists[i]) {
                squares.add(i * i);
            }
        }

        int m = squares.size();
        // Now run the check on the much smaller 'squares' list
        // Even if N=100,000, 'm' will never be more than 1000
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int sum = squares.get(i) + squares.get(j);
                
                // Check if the sum is a perfect square AND its root exists in our array
                int root = (int) Math.sqrt(sum);
                if (root * root == sum && root <= 1000 && exists[root]) {
                    return true;
                }
            }
        }

        return false;
    }
}
