// PROBLEM : Strings Rotations of Each other

// SOLUTION : KMP ALgorithm 

class Solution {
    public boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;

        String text = s1 + s1;
        return kmpSearch(text, s2);
    }

    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] buildLPS(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0, i = 1;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}



// METHOD 1: 
class Solution {
    public boolean areRotations(String s1, String s2) {
        // code here
        // checking the length of the string 
        if(s1.length() != s2.length())
            return false;
            
        // Main logic -> Concatenate s1 string with itself.         
        String doubled = s1+s1;
        
        return doubled.contains(s2);
        // Result -> Check if s2 is present in the concatenated string.
        // This covers both left and right rotations.
    }
}
