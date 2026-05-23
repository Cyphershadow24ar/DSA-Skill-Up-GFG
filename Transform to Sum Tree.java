// PROBLEM : Transform to Sum Tree

// SOLUTION :

class Solution {
    public void toSumTree(Node root) {
        helper(root);
    }
    
    int helper(Node root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        int rootData = root.data;
        root.data = left + right;
        return left + right + rootData;
    }
}
