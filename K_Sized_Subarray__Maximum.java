// PROBLEM : K Sized Subarray Maximum

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        // Deque will store indices of elements
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            // 1. Remove indices that are out of the current window range
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // 2. Remove indices of elements smaller than the current element
            // because they will never be the maximum again
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // 3. Add current element's index to the back
            dq.offerLast(i);

            // 4. The front of the deque is the largest element for the current window
            // Only start adding to results once we have reached at least k elements
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }
}
