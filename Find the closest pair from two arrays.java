// PROBLEM : Find the closest pair from two arrays

// SOLUTION :

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n = arr1.length;
        int m = arr2.length;
        
        // Pointers for arr1 (start) and arr2 (end)
        int left = 0;
        int right = m - 1;
        
        int minDiff = Integer.MAX_VALUE;
        int bestA = -1;
        int bestB = -1;
        
        while (left < n && right >= 0) {
            int currentSum = arr1[left] + arr2[right];
            int currentDiff = Math.abs(currentSum - x);
            
            // If we found a closer pair, update our results
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                bestA = arr1[left];
                bestB = arr2[right];
            }
            
            // Move pointers based on the sum relative to x
            if (currentSum > x) {
                right--; // Need a smaller sum
            } else if (currentSum < x) {
                left++;  // Need a larger sum
            } else {
                // Exact match found (diff is 0)
                break;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(bestA);
        result.add(bestB);
        return result;
    }
}
