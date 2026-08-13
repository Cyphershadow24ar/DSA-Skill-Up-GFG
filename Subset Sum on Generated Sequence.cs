// PROBLEM : Subset Sum on Generated Sequence

// SOLUTION :

using System;
using System.Collections.Generic;

class Solution {
    public bool isPossible(int[] arr, int s, int x) {
        // Handle edge case where target is already 0
        if (x == 0) return true;

        List<long> seq = new List<long>();
        
        long currentSum = s;
        seq.Add(s);

        // 1. Generate sequence based on paper writing rules
        foreach (int val in arr) {
            // Stop generating if the sum already exceeds x
            if (currentSum > x) break;

            long nextVal = currentSum + val;
            seq.Add(nextVal);
            currentSum += nextVal;
        }

        // 2. Greedy selection from largest to smallest
        long target = x;
        for (int i = seq.Count - 1; i >= 0; i--) {
            if (seq[i] <= target) {
                target -= seq[i];
            }
        }

        return target == 0;
    }
}
