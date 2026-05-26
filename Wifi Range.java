// PROBLEM : Wifi Range

// SOLUTION :

class Solution {
    public boolean wifiRange(String s, int x) {
        // code here
        int n = s.length();
        
        int maxcov = -1;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                if(i - maxcov -1 > x){
                    return false;
                }
                maxcov = i + x;
                
            }
            
        }
        return maxcov >= n-1;
    }
}
