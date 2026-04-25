// PROBLEM  : Opposite Sign Pair Reduction

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int val : arr) {
            boolean currentDestroyed = false;

            // While there is a potential collision (opposite signs)
            while (!stack.isEmpty() && isOpposite(stack.peek(), val)) {
                int top = stack.peek();
                int absTop = Math.abs(top);
                int absVal = Math.abs(val);

                if (absTop < absVal) {
                    // Current is stronger: destroy stack top and keep checking
                    stack.pop();
                    continue; 
                } else if (absTop == absVal) {
                    // Equal strength: both destroyed
                    stack.pop();
                    currentDestroyed = true;
                    break;
                } else {
                    // Stack top is stronger: current is destroyed
                    currentDestroyed = true;
                    break;
                }
            }

            // If the current element survived all collisions, add it to stack
            if (!currentDestroyed) {
                stack.push(val);
            }
        }

        return new ArrayList<>(stack);
    }

    // Helper to check if signs are opposite
    private boolean isOpposite(int a, int b) {
        return (a > 0 && b < 0) || (a < 0 && b > 0);
    }
}
