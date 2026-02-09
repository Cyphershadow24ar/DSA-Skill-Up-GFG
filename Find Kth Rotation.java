// PROBLEM : Find Kth Rotation

// SOLUITON :

class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {

            // If already sorted
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            // Check if mid is minimum
            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }

            // Decide which half to search
            if (arr[mid] <= arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
