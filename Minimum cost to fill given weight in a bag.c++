// PROBLEM : Minimum cost to fill given weight in a bag


// SOLUTION :

class Solution {
  public:
  
  
     int n;

    
    int solve(vector<int>&cost ,int buy, int idx,  vector<vector<int>>&dp){
          
          if(buy==0){
               return 0;
          }
          
          if(buy<0) return INT_MAX;
          if(idx>=n){
               if(buy==0)return 0;
               else return INT_MAX;
          }
          if(dp[buy][idx]!=-1 )return dp[buy][idx];
          if(cost[idx]==-1) {
              return solve(cost, buy, idx + 1,dp);
          }
          
       
          int take = solve(cost , buy-idx-1,idx+1,dp);
          int take2 = solve(cost , buy-idx-1,idx,dp);
          if (take!=INT_MAX) {
              take += cost[idx];
            
          }
          if (take2!=INT_MAX) {
              take2 += cost[idx];
            
          }
          int ntake = solve(cost , buy,idx+1,dp);
        //   int ntake =INT_MAX;
          return dp[buy][idx]=min(take, min(ntake,take2));
          
    }
   
    int minimumCost(vector<int> &cost, int w) {
        // code here
         n = cost.size();
          vector<vector<int>>dp(w+1,vector<int>(n+1,-1));
            int ans =solve(cost , w, 0,dp);
      
         return (ans == INT_MAX) ? -1 : ans;
    }
};
