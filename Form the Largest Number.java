// PROBLEM : Form the Largest Number

// SOLUTION :

import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        
        // Step 1: Convert int -> String
        String[] str = new String[arr.length];
        for(int i = 0; i < arr.length; i++)
            str[i] = String.valueOf(arr[i]);

        // Step 2: Custom sort
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Edge case (all zeros)
        if(str[0].equals("0"))
            return "0";

        // Step 4: Build answer
        StringBuilder ans = new StringBuilder();
        for(String s : str)
            ans.append(s);

        return ans.toString();
    }
}
