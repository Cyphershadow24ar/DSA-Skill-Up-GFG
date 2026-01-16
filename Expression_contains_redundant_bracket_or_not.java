// PROBLEM : Expression contains redundant bracket or not

// SOLUTION :

class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If closing bracket, check redundancy
            if (ch == ')') {
                boolean hasOperator = false;

                // Pop till opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Remove '('
                stack.pop();

                // If no operator inside brackets
                if (!hasOperator) {
                    return true;
                }
            } 
            else {
                stack.push(ch);
            }
        }
        return false;
    }
}
