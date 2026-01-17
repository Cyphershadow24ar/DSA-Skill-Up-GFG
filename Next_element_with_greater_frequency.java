// PROBLEM : Next element with greater frequency

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 1: Frequency map
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        
        // Step 2: Stack to store indices
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements with <= frequency
            while (!stack.isEmpty() && 
                   freq.get(arr[stack.peek()]) <= freq.get(arr[i])) {
                stack.pop();
            }
            
            // If stack empty, no greater frequency element
            ans[i] = stack.isEmpty() ? -1 : arr[stack.peek()];
            
            // Push current index
            stack.push(i);
        }
        
        // Convert to ArrayList
        for (int x : ans) {
            result.add(x);
        }
        
        return result;
    }
}
