// PROBLEM : Union of Arrays with Duplicates

// SOLUTION :

import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements of array a
        for (int num : a) {
            set.add(num);
        }
        
        // Add all elements of array b
        for (int num : b) {
            set.add(num);
        }
        
        // Convert set to ArrayList
        return new ArrayList<>(set);
    }
}
