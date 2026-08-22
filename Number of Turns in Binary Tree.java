// PROBLEM : Number of Turns in Binary Tree

// SOLUTION : 

/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    private int c = 0 ;
    
    public int numberOfTurns(Node root, int p, int q) {
        // code here
        Node a = lca(root, p, q);
        c = 0;
        
        if(a.data == p || a.data == q){
            int target = (a.data == p) ? q : p;
            turns(a.left, target, true, 0);
            turns(a.right, target, false, 0);
            return c == 0 ? -1 : c;
            
        }
        
        turns(a.left, p, true, 0);
        turns(a.right, p, false, 0);
        
        turns(a.left,  q, true, 0);
        turns(a.right, q, false, 0);
        
        return c + 1;
    }
    
    private Node lca(Node root, int p, int q){
        if(root == null || root.data == p || root.data == q) return root;
        
        
        Node l = lca(root.left, p, q);
        Node r = lca(root.right, p, q);
        
        if(l != null && r != null) return root;
        return l != null ? l : r;
        
    }
    
    private boolean turns(Node n, int k, boolean d, int k){
        if(n == null) return false;
        
        if(n.data == k){
            c = t;
            return true;
        }
        
        if(turns(n.left, k, true, d ? t : t + 1)) return true;
        if(turns(n.right, k, false, !d ? t : t + 1)) return true;
        
        return false;
    }
}
