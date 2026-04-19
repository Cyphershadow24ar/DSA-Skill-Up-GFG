// PROBLEM : Count Derangements

// SOLUTION :

class Solution {
    public int derangeCount(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        
        int a = 0; // D(1)
        int b = 1; // D(2)
        
        for(int i = 3; i <= n; i++){
            int c = (i - 1) * (a + b);
            a = b;
            b = c;
        }
        
        return b;
    }
}
