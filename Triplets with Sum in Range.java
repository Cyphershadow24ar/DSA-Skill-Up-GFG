// Problem : Triplets with Sum in Range

// Solution :

class Solution {

    public int countTriplets(int[] arr, int l, int r) {

        java.util.Arrays.sort(arr);

        int n = arr.length;

        long ansR = 0;
        long ansL = 0;

        // Count triplets with sum <= r
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum <= r) {
                    ansR += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        // Count triplets with sum < l
        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = (long) arr[i] + arr[left] + arr[right];

                if (sum < l) {
                    ansL += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return (int) (ansR - ansL);
    }
}
