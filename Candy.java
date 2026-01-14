// PROBLEM : Candy

// SOLUTION :

class Solution {
    public int minCandy(int arr[]) {
        // code here
        int n = arr.length;
        if(n == 0) return 0;
        
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for(int i= 1; i<n ; i++){
            if(arr[i] > arr[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            if(arr[i] > arr[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        int total = 0;
        for(int c : candies){
            total += c;
        }
        
        return total;
        
    }
}
