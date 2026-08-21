// PROBLEM : Transform String

// SOLUTION : 

class Solution {
     int transform(String s1, String s2) {
         if (s1.length() != s2.length()) {
             return -1;
         }

         // Step 1: Check if both strings are anagrams using a frequency map
         int[] count = new int[256];
         for (int i = 0; i < s1.length(); i++) {
             count[s1.charAt(i)]++;
             count[s2.charAt(i)]--;
         }

         for (int c : count) {
             if (c != 0) {
                 return -1; // Character frequencies do not match
             }
         }

         // Step 2: Traverse from right to left to count required moves
         int i = s1.length() - 1;
         int j = s2.length() - 1;
         int operations = 0;

         while (i >= 0) {
             if (s1.charAt(i) == s2.charAt(j)) {
                 j--; // Character matches, move pointer for s2
             } else {
                 operations++; // Move s1[i] to the front, increment count
             }
             i--; // Always move pointer for s1
         }

         return operations;
     }
 }
