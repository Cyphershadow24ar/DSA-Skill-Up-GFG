// PROBLEM : Largest BST

// SOLUTION :

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class NodeInfo{
    int size;
    int maxval;
    int minval;
    boolean isbst;
    
    NodeInfo(int size, int maxval, int minval, boolean isbst){
        this.size = size;
        this.maxval = maxval;
        this.minval = minval;
        this.isbst = isbst;
    }
}

class Solution {
    static int maxsize = 0;
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        maxsize = 0;
        solve(root);
        return maxsize;
    }
    
    private static NodeInfo solve(Node root){
        if(root == null){
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        
        NodeInfo left = solve(root.left);
        NodeInfo right = solve(root.right);
        
        int currsize = left.size + right.size + 1;
        if(left.isbst && right.isbst && root.data > left.maxval && root.data < right.minval){
            maxsize = Math.max(maxsize, currsize);
            
            int minval = (root.left != null) ? left.minval : root.data;
            int maxval = (root.right != null) ? right.maxval : root.data;
            
            return new NodeInfo(currsize, maxval, minval, true);
        }
        return new NodeInfo(currsize, 0, 0, false);
    }
}
