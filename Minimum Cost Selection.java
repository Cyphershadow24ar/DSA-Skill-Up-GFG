// Problem : Minimum Cost Selection

// Solution : 

class Solution {
    public int minCost(int[][] mat) {
        // code here
        int a = mat[0][0], b = mat[0][1], c = mat[0][2];
        
        for(int i = 1; i<mat.length; i++){
            int x = mat[i][0] + Math.min(b, c);
            int y = mat[i][1] + Math.min(a,c);
            int z = mat[i][2] + Math.min(a, b);
            
            a = x;
            b = y;
            c = z;
        }
        return Math.min(a, Math.min(b, c));
    }
}
