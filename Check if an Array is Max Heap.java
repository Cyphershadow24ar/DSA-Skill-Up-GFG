// PROBLEM : Check if an Array is Max Heap

// SOLUTION :

class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= (n / 2) - 1; i++) {
            
            int l = 2 * i + 1;
            int r = 2 * i + 2;

            if (l < n && arr[i] < arr[l]) return false;
            if (r < n && arr[i] < arr[r]) return false;
        }

        return true;
    }
}
