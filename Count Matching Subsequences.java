// PROBLEM : Count Matching Subsequences

// SOLUTION :
class Solution {
    static int mod = (int)(1e9 + 7);
    public static int countWays(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n][m];
        for (int[] d : dp) Arrays.fill(d, -1);
        return func(n-1, m-1, s1, s2, dp);
    }
    
    static int func(int i,int j , String s1, String s2, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int cnt  = 0;
        
        if(s1.charAt(i) != s2.charAt(j)) {
            cnt += func(i-1, j, s1, s2, dp);
        } else {
            cnt += func(i-1, j, s1, s2, dp);
            cnt += func(i-1, j-1, s1, s2, dp);
        }
        return dp[i][j] = cnt % mod;
    }
}

