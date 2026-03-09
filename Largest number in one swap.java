// PROBLEM : Largest number in one swap

// SOLUTION :

class Solution {
    public String largestSwap(String s) {
        // code here
        char[] arr = s.toCharArray();
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            int maxIdx = i;
            
            for(int j=i+1; j<n; j++){
                if(arr[j] >= arr[maxIdx]){
                    maxIdx = j;
                }
            }
            
            if(arr[maxIdx] > arr[i]){
                char temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
                break;
            }
        }
        return new String(arr);
    }
}
