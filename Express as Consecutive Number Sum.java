// PROBLEM : Express as Consecutive Number Sum

// SOLUTION :

class Solution {
    public boolean isSumOfConsecutive(int n) {
        // If n is a power of 2, it cannot be expressed as sum of 
        // two or more consecutive positive integers.
        return (n & (n - 1)) != 0;
    }
}
