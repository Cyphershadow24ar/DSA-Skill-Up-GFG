// PROBLEM : Gray Code

// SOLUTION :

import java.util.*;

class Solution {
    public ArrayList<String> graycode(int n) {
        // Base case for n = 1
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }

        // Recursively get the sequence for n-1
        ArrayList<String> prevList = graycode(n - 1);
        ArrayList<String> result = new ArrayList<>();

        // 1. Add '0' to the front of the original sequence
        // This keeps the values small and maintains the "differ by one bit" property
        for (int i = 0; i < prevList.size(); i++) {
            result.add("0" + prevList.get(i));
        }

        // 2. Add '1' to the front of the reflected (reversed) sequence
        // Reversing ensures that the last item of the '0' block (e.g., 01) 
        // and the first item of the '1' block (e.g., 11) differ by only the first bit.
        for (int i = prevList.size() - 1; i >= 0; i--) {
            result.add("1" + prevList.get(i));
        }

        return result;
    }
}
