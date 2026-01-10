// PROBLEM : Substrings with K Distinct

// SOLUTION :

class Solution {
    public int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    private int countAtMostK(String s, int k) {
        if (k == 0) return 0;

        int left = 0, result = 0;
        int[] freq = new int[26];
        int distinct = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (freq[ch - 'a'] == 0) {
                distinct++;
            }
            freq[ch - 'a']++;

            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }

            result += (right - left + 1);
        }
        return result;
    }
}
