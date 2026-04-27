// PROBLEM : Smallest window containing 0, 1 and 2

// SOLUTION :

class Solution {
    public int smallestSubstring(String s) {
        // code here
        int n= s.length();
        int[] cnt = new int[3];
        
        int l = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int r = 0 ; r<n; r++){
            cnt[s.charAt(r) - '0']++;
            
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                int len = r - l+ 1;
                if(len < ans){
                    ans = len;
                }
                cnt[s.charAt(l) - '0']--;
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
};
