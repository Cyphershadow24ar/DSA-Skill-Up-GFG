// PROBLEM : Flattening a Linked List

// SOLUTION: 

class Solution {
    
    // Function to merge two sorted linked lists using bottom pointer
    private Node merge(Node a, Node b) {
        // Base cases
        if (a == null) return b;
        if (b == null) return a;
        
        Node result;
        
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        
        result.next = null; // important: remove next pointer
        return result;
    }
    
    // Main flatten function
    public Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null)
            return root;
        
        // Recursively flatten the next list
        root.next = flatten(root.next);
        
        // Merge current list with flattened next list
        root = merge(root, root.next);
        
        return root;
    }
}
