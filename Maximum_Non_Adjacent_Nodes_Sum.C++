/* PROBLEM : Maximum Non-Adjacent Nodes Sum

Given the root of a binary tree with integer values.
Your task is to select a subset of nodes such that the sum of their values is maximized, with the condition that no two selected nodes are directly connected that is,
if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root = [11, 1, 2]
Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root = [1, 2, 3, 4, N, 5, 6]
Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5 and 6, which are not directly connected to each other. Their total sum is 16.  

Constraints:
1 ≤ number of nodes ≤ 104
1 ≤ node.data ≤ 105
*/

// SOLUTION :

class Solution {
  public:
    pair<int, int> solve(Node* root) {
        if (!root) return {0, 0};

        auto left = solve(root->left);
        auto right = solve(root->right);

        // include this node -> cannot include children
        int include = root->data + left.second + right.second;
        // exclude this node -> take max of including/excluding children
        int exclude = max(left.first, left.second) + max(right.first, right.second);

        return {include, exclude};
    }

    int getMaxSum(Node *root) {
        auto ans = solve(root);
        return max(ans.first, ans.second);
    }
};
