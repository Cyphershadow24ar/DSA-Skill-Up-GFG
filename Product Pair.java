// PROBLEM : Product Pair

// SOLUTION :
import java.util.*;

class Solution {
    public boolean isProduct(int[] arr, long target) {
        HashSet<Long> seen = new HashSet<>();

        // Special case: product 0
        // Any pair containing 0 gives product 0
        if (target == 0) {
            for (int x : arr) {
                if (x == 0 && arr.length > 1) return true;
            }
            return false;
        }

        for (int x : arr) {
            if (x == 0) {
                seen.add(0L);
                continue;
            }

            long val = x;

            if (target % val == 0) {
                long need = target / val;
                if (seen.contains(need)) {
                    return true;
                }
            }

            seen.add(val);
        }

        return false;
    }
}
