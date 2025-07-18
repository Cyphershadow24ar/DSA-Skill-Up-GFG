/*
PROBLEM - LCM Triplet

Given a number n. Find the maximum possible LCM that can be obtained by selecting three numbers less than or equal to n.
Note : LCM stands for Lowest Common Multiple.

Examples:

Input: n = 9
Output: 504
Explanation: 504 is the maximum LCM that can be attained by any triplet of numbers less than or equal 9. The triplet which has this LCM is {7, 8, 9}.

Input: n = 7
Output: 210
Explanation: 210 is the maximum LCM that can be attained by any triplet of numbers less than or equal 7. The triplet which has this LCM is {5, 6, 7}.

Constraints:
1 ≤ n ≤ 103
*/

// SOLUTION :-

class Solution {
  public:
    
    long long gcd(long long a, long long b){
        return b == 0 ? a : gcd(b,a%b);
    }
    
    long long lcm(long long a, long long b){
        return (a/gcd(a,b)) * b;
    }
    
    long long lcmOfThree(long long a, long long b, long long c){
        return lcm(a, lcm(b,c));
    }
    
    long long lcmTriplets(int n) {
        // code here
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 6;
        
        long long ans = 0;
        
        for(int i=n; i >= max(1, n-3); i--){
            for(int j = i - 1; j >= max(1, n -3); j--){
                for(int k = j-1; k >= max(1,n-3); k--){
                    ans = max(ans, lcmOfThree(i, j , k));
                }
            }
        }
        return ans;
    }
};
