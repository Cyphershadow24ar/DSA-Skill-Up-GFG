// PROBLEM : Anagram Palindrome

// SOLUTION :

class Solution {
    boolean canFormPalindrome(String s) {
        int[] freq = new int[26];
        
        // count frequency
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        
        int odd = 0;
        
        // count odd frequencies
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0){
                odd++;
            }
        }
        
        // check condition
        if(odd <= 1){
            return true;
        }
        
        return false;
    }
}
