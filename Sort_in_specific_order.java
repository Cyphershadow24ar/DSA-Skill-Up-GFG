// PROBLEM : Sort in specific order

// SOLUTION :

import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        // Step 1: Separate odd and even numbers
        for (int num : arr) {
            if (num % 2 != 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        // Step 2: Sort odd descending
        Collections.sort(odd, Collections.reverseOrder());

        // Step 3: Sort even ascending
        Collections.sort(even);

        // Step 4: Merge back into arr
        int index = 0;
        for (int num : odd) {
            arr[index++] = num;
        }
        for (int num : even) {
            arr[index++] = num;
        }
    }
}
