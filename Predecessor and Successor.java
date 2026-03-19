// PROBLEM : Predecessor and Successor

// SOLUTION :

/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        Node predecessor = null;
        Node successor = null;
        
        Node curr = root;
        
        // Find Successor
        while (curr != null) {
            if (curr.data > key) {
                successor = curr; // Potential successor
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        // Reset curr to find Predecessor
        curr = root;
        while (curr != null) {
            if (curr.data < key) {
                predecessor = curr; // Potential predecessor
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        
        ArrayList<Node> result = new ArrayList<>();
        result.add(predecessor);
        result.add(successor);
        return result;
    }
}
