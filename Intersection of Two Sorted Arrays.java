// PROBLEM : Intersection of Two Sorted Arrays

// SOLUTION :

import java.util.*;

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < a.length && j < b.length) {
            
            if(a[i] == b[j]) {
                // add only if not duplicate
                if(res.size() == 0 || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
            }
            else if(a[i] < b[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        
        return res;
    }
}
