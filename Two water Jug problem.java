// PROBLEM : Two water Jug problem

// SOLUTION :

class Solution {
    
    public int minSteps(int m, int n, int d) {
        
        // Edge case (YOU MISSED THIS)
        if (d == m || d == n) return 1;
        
        // Not possible cases
        if (d > Math.max(m, n)) return -1;
        if (d % gcd(m, n) != 0) return -1;
        
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    int pour(int fromCap, int toCap, int d) {
        
        int from = 0, to = 0, steps = 0;
        
        while (from != d && to != d) {
            
            if (from == 0) {
                from = fromCap;
                steps++;
            }
            
            int transfer = Math.min(from, toCap - to);
            to += transfer;
            from -= transfer;
            steps++;
            
            if (from == d || to == d) break;
            
            if (to == toCap) {
                to = 0;
                steps++;
            }
        }
        
        return steps;
    }
}
