// PROBLEM : Palindrome Binary

// SOLUTION :

class Solution {
    public boolean isBinaryPalindrome(int n) {
        int original = n;
        int reversed = 0;
        
        // Extract bits from 'original' and build 'reversed'
        while (original > 0) {
            // Shift 'reversed' to the left to make room for the next bit,
            // then use bitwise OR to add the last bit of 'original'
            reversed = (reversed << 1) | (original & 1);
            
            // Shift 'original' to the right to process the next bit
            original >>= 1;
        }
        
        // If the reversed binary value equals the original integer, it's a palindrome
        return n == reversed;
    }
}
