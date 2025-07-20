/* PROBLEM :- Count Numbers Containing Specific Digits

You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9. 
Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.

Examples:

Input: n = 1, arr[] = [1, 2, 3]
Output: 3
Explanation: Only the single-digit numbers [1, 2, 3] satisfy the condition.

Input: n = 2, arr[] = [3, 5]
Output: 34
Explanation: There are a total of 34  two digit numbers which contain atleast  one out of  [3, 5].

Constraints:
  1 ≤ n ≤ 9
  1 ≤ arr.size() ≤ 10
  0 ≤ arr[i] ≤ 9
*/

// SOLUTION :-

class Solution {
  public:
    int countValid(int n, vector<int>& arr) {
        // code here
        unordered_set<int> forbidden(arr.begin(), arr.end());
        
        int totalCount = 9;
        for(int i=1; i<n; i++) totalCount *= 10;
        
        vector<int> allowed;
        for(int d=0; d<=9; d++){
            if(!forbidden.count(d)) allowed.push_back(d);
        }
        
        if(allowed.empty()) return totalCount; 
        
        int allowedCount = allowed.size();
        int allowedNonZero = 0;
        for(int d : allowed) if(d != 0) allowedNonZero++;
        
        if( allowedNonZero == 0) return totalCount;
        
        long long badCount = allowedNonZero;
        for(int i =1; i<n ; i++) badCount *= allowedCount;
        
        return totalCount - (int)badCount;
    }
};
