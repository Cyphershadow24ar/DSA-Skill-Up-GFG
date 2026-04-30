// PROBLEM : Kth Largest in a Stream

// SOLUTION :

import java.util.*;

class Solution {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            
            if (pq.size() > k) {
                pq.poll();
            }
            
            if (pq.size() < k) {
                res.add(-1);
            } else {
                res.add(pq.peek());
            }
        }
        
        return res;
    }
}
