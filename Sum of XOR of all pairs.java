// PROBLEM : Sum of XOR of all pairs

// SOLUTION :

class Solution {
    public long sumXOR(int[] arr) {
        long totalSum = 0;
        int n = arr.length;
        
        // Loop through each bit position from 0 to 31
        for (int k = 0; k < 31; k++) {
            long countOnes = 0;
            
            // Count how many elements have the k-th bit set to 1
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << k)) != 0) {
                    countOnes++;
                }
            }
            
            // The rest of the elements must have the k-th bit set to 0
            long countZeros = n - countOnes;
            
            // Number of pairs that produce a 1 at this bit position
            long pairs = countOnes * countZeros;
            
            // Add the positional value of these pairs to the total sum
            // Using 1L to prevent integer overflow during the left shift
            totalSum += pairs * (1L << k);
        }
        
        return totalSum;
    }
}
