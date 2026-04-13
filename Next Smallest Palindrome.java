// PROBLEM : Next Smallest Palindrome

// SOLUTOIN :

class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        // Step 1: Check if all digits are 9
        boolean all9 = true;
        for (int x : num) {
            if (x != 9) {
                all9 = false;
                break;
            }
        }

        // Case: 999 → 1001
        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        // Step 2: Mirror left to right
        int[] res = num.clone();
        int i = 0, j = n - 1;

        while (i < j) {
            res[j] = res[i];
            i++;
            j--;
        }

        // Step 3: Check if mirrored > original
        boolean greater = false;
        for (int k = 0; k < n; k++) {
            if (res[k] > num[k]) {
                greater = true;
                break;
            } else if (res[k] < num[k]) {
                break;
            }
        }

        if (greater) return res;

        // Step 4: Increment middle
        int carry = 1;
        int mid = n / 2;

        // odd length → start from middle
        if (n % 2 == 1) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            i = mid - 1;
            j = mid + 1;
        } else {
            i = mid - 1;
            j = mid;
        }

        // propagate carry
        while (i >= 0 && carry > 0) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] %= 10;
            res[j] = res[i];
            i--;
            j++;
        }

        return res;
    }
}
