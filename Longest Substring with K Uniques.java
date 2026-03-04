// PROBLEM : Longest Substring with K Uniques

// SOLUTION :

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int l =0;
        int r =0;
        int maxlen = -1;
        
        int[] size = new int[26];
        int count =0;
        
        while(r < n){
            int ch = s.charAt(r) - 'a';
            if(size[ch] == 0){
                count++;
            }
            size[ch]++;
            
            while(count > k){
                int leftch =s.charAt(l) - 'a';
                size[leftch]--;
                if(size[leftch] == 0){
                    count--;
                }
                l++;
            }
            if(count == k){
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }
}
