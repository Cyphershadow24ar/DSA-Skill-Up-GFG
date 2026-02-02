// PROBLEM : Stock Buy and Sell – Max one Transaction Allowed

// SOLUTION : 

class Solution {
    public int maxProfit(int[] prices) {
        // Code here
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i=0; i< prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else{
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
