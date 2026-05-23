// PROBLEM : Last Coin in a Game of Alternates

// SOLUTION :

class Solution {
    public int coin(int[] arr) {
        // code here
         int left  = 0;
         int right = arr.length-1;
         
         while(left < right){
              if(arr[left] >= arr[right]){
                  left++;
              }else{
                  right--;
              }
         }
         return arr[left];
    }
}
