// PROBLEM : Koko Eating Bananas

// SOLUTION :

class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int low = 1;
        int high = 0;
        
        for(int bananas : arr){
            high = Math.max(high, bananas);
        }
        
        int ans = high;
        while(low <= high){
            int mid = low +(high - low)/2;
            long hrsNeed = 0;
            for(int bananas : arr){
                hrsNeed += (bananas + mid - 1) /mid;
            }
            
            if(hrsNeed <= k){
                ans = mid;
                high = mid -1;
            } else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
