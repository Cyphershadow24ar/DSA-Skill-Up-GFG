// PROBLEM : Minimum Toogles to partition

// SOLUTION :

class Solution {
    int minToggle(int[] arr) {
        // code here
        int n = arr.length;
        int tc = 0 ;
        
        for(int x : arr){
            if(x == 0) tc++;
        }
        
        int ans  = tc;
        int l = 0;
        int l1 = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] == 0) l++;
            else l1++;
            
            int cur = l1 + (tc - l);
            if(cur < ans){
                ans = cur;
            }
        }
        return ans;
    }
}
