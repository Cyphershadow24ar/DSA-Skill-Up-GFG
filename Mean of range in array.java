// PROBLEM : Mean of range in array

// SOLUTION :

class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            
            long rangesum;
            
            if(l == 0){
                rangesum = prefixSum[r];
            }else{
                rangesum = prefixSum[r] - prefixSum[l - 1];
            }
            
            int count = r - l + 1;
            int mean = (int) (rangesum / count);
            result.add(mean);
        }
        return result;
    }
}
