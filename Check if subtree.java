// PROBLEM : Check if subtree

// SOLUTION :

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // Base cases
        if (root2 == null) {
            return true; // A null tree is a subtree of any tree
        }
        if (root1 == null) {
            return false; // A non-null tree cannot be a subtree of a null tree
        }

        // Check if the trees rooted at the current nodes are identical
        if (isIdentical(root1, root2)) {
            return true;
        }

        // If not identical, recursively check the left and right subtrees of root1
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private boolean isIdentical(Node node1, Node node2) {
        // If both nodes are null, they are identical up to this point
        if (node1 == null && node2 == null) {
            return true;
        }
        
        // If only one of the nodes is null, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }

        // Check if the current data matches AND left subtrees match AND right subtrees match
        return (node1.data == node2.data) && 
               isIdentical(node1.left, node2.left) && 
               isIdentical(node1.right, node2.right);
    }
}
