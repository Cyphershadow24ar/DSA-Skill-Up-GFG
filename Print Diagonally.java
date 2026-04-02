// PROBLEM : Print Diagonally

// SOLUTION :

class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        int n =mat.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int c= 0; c<n; c++){
            int i=0 , j =c;
            while(i < n && j >= 0){
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }
        
        for(int r= 1; r<n; r++){
            int i = r, j = n-1;
            while(i <n && j >= 0){
                res.add(mat[i][j]);
                i++;
                j--;
            }
        }
        return res;
    }
}
