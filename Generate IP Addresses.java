// PROBLEM : Generate IP Addresses

// SOLUTION :

import java.util.*;

class Solution {
    
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }
    
    private void backtrack(String s, int index, int part, String current, ArrayList<String> result) {
        
        // If 4 parts created and string fully used
        if (part == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        
        // If parts exceed or string finished early
        if (part == 4 || index == s.length()) {
            return;
        }
        
        // Try segments of length 1 to 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            
            String segment = s.substring(index, index + len);
            
            if (isValid(segment)) {
                backtrack(s, index + len, part + 1, current + segment + ".", result);
            }
        }
    }
    
    private boolean isValid(String segment) {
        
        // Leading zero check
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        
        int num = Integer.parseInt(segment);
        
        return num >= 0 && num <= 255;
    }
}
