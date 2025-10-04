/* PROBLEM : Expression Add Operators

Given a string s that contains only digits (0-9) and an integer target, return all possible strings by inserting the binary operator ' + ', ' - ', and/or ' * ' 
between the digits of s such that the resultant expression evaluates to the target value.

Note:

Operands in the returned expressions should not contain leading zeros. For example, 2 + 03 is not allowed whereas 20 + 3 is fine.
It is allowed to not insert any of the operators.
Driver code will print the final list of strings in lexicographically smallest order.

Examples:

Input: s = "124", target = 9
Output: ["1+2*4"]
Explanation: The valid expression that evaluate to 9 is 1 + 2 * 4

Input: s = "125", target = 7
Output: ["1*2+5", "12-5"]
Explanation: The two valid expressions that evaluate to 7 are 1 * 2 + 5 and 12 - 5.

Input: s = "12", target = 12
Output: ["12"] 
Explanation: s itself matches the target. No other expressions are possible.

Input: s = "987612", target = 200
Output: []
Explanation: There are no expressions that can be created from "987612" to evaluate to 200.

Constraints:
1 ≤ s.size() ≤ 9
s consists of only digits (0-9).
-231 ≤ target ≤ 231-1
*/

// SOLUTION :

class Solution {
public:
    vector<string> findExpr(string &s, int target) {
        vector<string> ans;
        string path;
        dfs(s, target, 0, 0, 0, path, ans);
        sort(ans.begin(), ans.end()); // ensure lexicographic order
        return ans;
    }

    void dfs(string &s, long long target, int pos, long long eval,
             long long prevNum, string path, vector<string> &ans) {
        if (pos == s.size()) {
            if (eval == target) ans.push_back(path);
            return;
        }

        for (int i = pos; i < s.size(); i++) {
            // skip leading zeros
            if (i != pos && s[pos] == '0') break;

            string curStr = s.substr(pos, i - pos + 1);
            long long curNum = stoll(curStr);

            if (pos == 0) {
                // first number, no operator before
                dfs(s, target, i + 1, curNum, curNum, curStr, ans);
            } else {
                // try +
                dfs(s, target, i + 1, eval + curNum, curNum, path + "+" + curStr, ans);

                // try -
                dfs(s, target, i + 1, eval - curNum, -curNum, path + "-" + curStr, ans);

                // try *
                dfs(s, target, i + 1, eval - prevNum + prevNum * curNum,
                    prevNum * curNum, path + "*" + curStr, ans);
            }
        }
    }
};
