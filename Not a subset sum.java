// PROBLEM : Not a subset sum

// SOLUTION :

import java.util.*;

class Solution {
    public int findSmallest(int[] arr) {

        Arrays.sort(arr);

        long x = 1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > x) {
                return (int)x;
            }

            x = x + arr[i];
        }

        return (int)x;
    }
}
