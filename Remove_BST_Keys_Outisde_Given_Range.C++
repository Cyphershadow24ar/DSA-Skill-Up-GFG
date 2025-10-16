// PROBLEM : Remove BST keys outside given range

// SOLUTION : 

class Solution {
  public:
    Node* removekeys(Node* root, int l, int r) {
        if (!root) return NULL;
        
        // First, fix the left and right subtrees
        root->left = removekeys(root->left, l, r);
        root->right = removekeys(root->right, l, r);
        
        // If current node is smaller than l, we discard left subtree
        if (root->data < l) {
            Node* rightChild = root->right;
            delete root; // optional memory cleanup
            return rightChild;
        }
        
        // If current node is greater than r, we discard right subtree
        if (root->data > r) {
            Node* leftChild = root->left;
            delete root; // optional memory cleanup
            return leftChild;
        }
        
        // Node is within range, keep it
        return root;
    }
};
