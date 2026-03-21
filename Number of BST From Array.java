// PROBLEM : Number of BST From Array

// SOLUTION :

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        int[] catalan = {1,1,2,5,14,42,132};
        
        for(int i=0; i<n; i++){
            int lc =0;
            int rc = 0;
            
            for(int j= 0; j<n; j++){
                if(i == j) continue;
                if(arr[j] < arr[i]){
                    lc++;
                }else{
                    rc++;
                }
            }
            result.add(catalan[lc] * catalan[rc]);
        }
        return result;
    }
}
