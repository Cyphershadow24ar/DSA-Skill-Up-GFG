// PROBLEM : Size of Binary Tree

// SOLUTION :

/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int getSize(Node root) {
        // Base case: if tree is empty
        if (root == null) {
            return 0;
        }
        
        // Count current node + left subtree + right subtree
        return 1 + getSize(root.left) + getSize(root.right);
    }
}
