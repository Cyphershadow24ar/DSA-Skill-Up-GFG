// PROBLEM : The Painter's Partition Problem-II

// SOLUTION :

class Solution {
    public long minTime(int[] arr, int k) {
        long low = 0;
        long high = 0;
        
        for (int board : arr) {
            low = Math.max(low, board); // Max element
            high += board;              // Sum of all elements
        }
        
        long result = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                result = mid;   // This time works, try to find a smaller one
                high = mid - 1;
            } else {
                low = mid + 1;  // Need more time per painter
            }
        }
        
        return result;
    }
    
    private boolean isPossible(int[] arr, int k, long maxTime) {
        int paintersUsed = 1;
        long currentTime = 0;
        
        for (int board : arr) {
            if (currentTime + board <= maxTime) {
                currentTime += board;
            } else {
                // Assign to next painter
                paintersUsed++;
                currentTime = board;
                
                // If we need more painters than available
                if (paintersUsed > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
