// PROBLEM : Remove Invalid Parentheses

// SOLUTION :

import java.util.*;

class Solution {
    public List<String> validParenthesis(String s) {
        int minLeft = 0;
        int minRight = 0;

        // Step 1: Calculate the minimum removals needed for '(' and ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minLeft++;
            } else if (c == ')') {
                if (minLeft > 0) {
                    minLeft--;
                } else {
                    minRight++;
                }
            }
        }

        // Use a TreeSet to ensure results are unique and lexicographically sorted
        TreeSet<String> result = new TreeSet<>();
        backtrack(s, 0, 0, 0, minLeft, minRight, new StringBuilder(), result);
        
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int open, int close, 
                           int remLeft, int remRight, StringBuilder sb, TreeSet<String> result) {
        
        // Base case: processed the entire string
        if (index == s.length()) {
            if (remLeft == 0 && remRight == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int currentLen = sb.length();

        if (c == '(') {
            // Option 1: Remove this '('
            if (remLeft > 0) {
                backtrack(s, index + 1, open, close, remLeft - 1, remRight, sb, result);
            }
            // Option 2: Keep this '('
            sb.append(c);
            backtrack(s, index + 1, open + 1, close, remLeft, remRight, sb, result);
            sb.setLength(currentLen); // Backtrack

        } else if (c == ')') {
            // Option 1: Remove this ')'
            if (remRight > 0) {
                backtrack(s, index + 1, open, close, remLeft, remRight - 1, sb, result);
            }
            // Option 2: Keep this ')' if it doesn't break the sequence (open > close)
            if (open > close) {
                sb.append(c);
                backtrack(s, index + 1, open, close + 1, remLeft, remRight, sb, result);
                sb.setLength(currentLen); // Backtrack
            }
        } else {
            // For lowercase letters, we must keep them
            sb.append(c);
            backtrack(s, index + 1, open, close, remLeft, remRight, sb, result);
            sb.setLength(currentLen); // Backtrack
        }
    }
}
