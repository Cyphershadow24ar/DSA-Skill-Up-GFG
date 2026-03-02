// PROBLEM : Longest subarray with Atmost two distinct integers

// SOLUTION :

class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n= arr.length;
        if(n <= 2) return n;
        
        int l =0;
        int maxlen = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int r =0; r<n; r++){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            
            while(map.size() > 2){
                map.put(arr[l], map.get(arr[l])-1);
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r-l + 1);
        }
        return maxlen;
    }
}
