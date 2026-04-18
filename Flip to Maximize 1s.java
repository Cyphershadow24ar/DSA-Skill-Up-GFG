// PROBLEM : Flip to Maximize 1s

// SOLUTION :

class Solution {
    int maxOnes(int[] arr) {
        int n = arr.length;
        int originalOnes = 0; 
        
        int currGain = 0;
        int maxGain = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                originalOnes++;
            }

            int val = (arr[i] == 0) ? 1 : -1;
            
            currGain += val;
            
            if(currGain > maxGain) {
                maxGain = currGain;
            }
            
            if(currGain < 0) {
                currGain = 0;
            }
        }
        
        return originalOnes + maxGain;
    }
}
