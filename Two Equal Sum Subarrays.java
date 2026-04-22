// PROBLEM : Two Equal Sum Subarrays

// SOLUTION :

class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        
        int total = 0;
        for(int i =0; i<n; i++){
            total += arr[i];
        }
        
        if(total % 2 != 0) return false;
        
        int pre = 0;
        for(int i = 0; i<n; i++){
            pre += arr[i];
            
            if(pre == total / 2 ){
                return true;
            }
        }
        
        return false;
    }
}
