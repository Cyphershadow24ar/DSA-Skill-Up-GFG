// PROBLEM : Count Subset With Target Sum II

// SOLUTION :

import java.util.*;

class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();

        generateSums(left, 0, 0, leftSums);
        generateSums(right, 0, 0, rightSums);

        // Count frequency of sums in right half
        Map<Integer, Integer> freq = new HashMap<>();
        for (int sum : rightSums) {
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        int count = 0;
        for (int sum : leftSums) {
            count += freq.getOrDefault(k - sum, 0);
        }

        return count;
    }

    private void generateSums(int[] arr, int idx, int currSum, List<Integer> sums) {
        if (idx == arr.length) {
            sums.add(currSum);
            return;
        }
        generateSums(arr, idx + 1, currSum, sums);               // exclude
        generateSums(arr, idx + 1, currSum + arr[idx], sums);    // include
    }
}
