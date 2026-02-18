// PROBLEM : Count Inversions

// SOLUTION :

class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return mergesort(arr, 0, arr.length -1);
    }
    
    static int mergesort(int arr[], int low, int high){
        int count = 0;
        if(low < high){
            int mid = (low + high)/2;
            
            count += mergesort(arr, low, mid);
            count += mergesort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }
    
    static int merge(int arr[], int low, int mid, int high){
        int temp[] = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                count += (mid - i + 1);
                temp[k++] = arr[j++];
            }
        }
        
        while(i<=mid) temp[k++] = arr[i++];
        while(j <= high) temp[k++] = arr[j++];
        
        for(i = low; i<= high; i++){
            arr[i] = temp[i - low];
        }
        
        return count;
    }
}
