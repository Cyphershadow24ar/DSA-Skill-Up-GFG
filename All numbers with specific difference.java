// PROBLEM : All numbers with specific difference

// SOLUTION :

class Solution {
    public int getCount(int n, int d) {
        // code here
        int low=1, high = n;
        int firstOcc =-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(mid - sumofd(mid) >=d){
                firstOcc = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        if(firstOcc == -1){
            return 0;
        }
        
        return (n-firstOcc + 1);
    }
    
    private int sumofd(int num){
        int sum  = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
};
