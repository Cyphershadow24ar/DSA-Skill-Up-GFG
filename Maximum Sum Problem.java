// PROBLEM : Maximum Sum Problem

// SOLUTION :

class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int maxSum(int n) {
        // code here.
        return solve(n);
    }
    
    int solve(int n){
        // always first right base case
        if(n == 0){
            return 0;
        }
        
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        
        // Recursive breaking
        int breakval =
                solve(n / 2) +
                solve(n / 3) +
                solve(n / 4);

        
        int ans = Math.max(n, breakval); // max
        
        dp.put(n, ans); // stores the answer
        
        return ans;
    }
}
