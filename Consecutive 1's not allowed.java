// PROBLEM : Consecutive 1's not allowed

// SOLUTION :

class Solution {
    int countStrings(int n) {
        // code here
        if( n== 0) return 0;
        
        int a = 1;
        int b = 1;
        
        for(int i =1; i<n; i++){
            int temp  = a;
            a = a + b;
            b = temp;
        }
        return a + b;
    }
}
