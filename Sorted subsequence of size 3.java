// PROBLEM : Sorted subsequence of size 3

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        
        int[] smaller = new int[n];
        int[] greater = new int[n];
        
        // Step 1: Fill smaller[]
        int minIndex = 0;
        smaller[0] = -1;
        
        for(int i = 1; i < n; i++) {
            if(arr[i] <= arr[minIndex]) {
                minIndex = i;
                smaller[i] = -1;
            } else {
                smaller[i] = minIndex;
            }
        }
        
        // Step 2: Fill greater[]
        int maxIndex = n - 1;
        greater[n - 1] = -1;
        
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] >= arr[maxIndex]) {
                maxIndex = i;
                greater[i] = -1;
            } else {
                greater[i] = maxIndex;
            }
        }
        
        // Step 3: Find valid triplet
        for(int i = 0; i < n; i++) {
            if(smaller[i] != -1 && greater[i] != -1) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(arr[smaller[i]]);
                res.add(arr[i]);
                res.add(arr[greater[i]]);
                return res;
            }
        }
        
        return new ArrayList<>(); // empty if not found
    }
}
