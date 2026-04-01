// PROBLEM : Painting the Fence

// SOLUTION:

class Solution {
  public:
    int countWays(int n, int k) {
        if(n == 1) return k;
        // code here
        int s = 0;
        int d = k;
        int t= k;
        for(int i=2; i<= n;i++){
            s = d;
            d = t*(k-1);
            t = s + d;
            
        }
        return t;
        
    }
};
