// PROBLEM : Smallest window containing all characters

// SOLUTION :

class Solution {
    public static String minWindow(String s, String p) {
        int n = s.length();
        int m = p.length();

        if (n < m) return "";

        // Frequency arrays for characters (assuming lowercase English as per constraints)
        // Using 256 to cover all ASCII characters just in case
        int[] pFreq = new int[256];
        int[] windowFreq = new int[256];

        for (int i = 0; i < m; i++) {
            pFreq[p.charAt(i)]++;
        }

        int left = 0, startIdx = -1, minLen = Integer.MAX_VALUE;
        int count = 0; // To track how many characters of p are satisfied

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            windowFreq[c]++;

            // If current char is needed in p and window has enough/less of it
            if (pFreq[c] != 0 && windowFreq[c] <= pFreq[c]) {
                count++;
            }

            // If window contains all characters of p
            if (count == m) {
                // Try to shrink the window from the left
                while (windowFreq[s.charAt(left)] > pFreq[s.charAt(left)] || pFreq[s.charAt(left)] == 0) {
                    windowFreq[s.charAt(left)]--;
                    left++;
                }

                // Update minLen and startIdx
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIdx = left;
                }
            }
        }

        if (startIdx == -1) return "";
        return s.substring(startIdx, startIdx + minLen);
    }
}
