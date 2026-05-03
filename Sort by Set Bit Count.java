// PROBLEM : Sort by Set Bit Count

// SOLUTION :

import java.util.*;

class Solution {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {

        Integer[] b = new Integer[arr.length];

        // convert int[] → Integer[]
        for (int i = 0; i < arr.length; i++) {
            b[i] = arr[i];
        }

        // sort based on set bits (descending)
        Arrays.sort(b, new Comparator<Integer>() {
            public int compare(Integer a, Integer c) {
                int x = Integer.bitCount(a);
                int y = Integer.bitCount(c);

                if (x != y) {
                    return y - x; // descending
                }
                return 0; // keep original order (stable sort)
            }
        });

        // store result
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < b.length; i++) {
            res.add(b[i]);
        }

        return res;
    }
}
