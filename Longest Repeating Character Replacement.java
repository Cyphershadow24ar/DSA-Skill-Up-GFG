// PROBLEM : Longest Repeating Character Replacement

// SOLUTION :

class Solution {
    public int longestSubstr(String s, int k) {
        int n = s.length();
        int[] f = new int[26];
        
        int l = 0, maxf = 0, ans = 0;
        
        for (int r = 0; r < n; r++) {
            int idx = s.charAt(r) - 'A';
            f[idx]++;
            
            if (f[idx] > maxf) {
                maxf = f[idx];
            }
            
            while ((r - l + 1) - maxf > k) {
                f[s.charAt(l) - 'A']--;
                l++;
            }
            
            int len = r - l + 1;
            if (len > ans) ans = len;
        }
        
        return ans;
    }
}
