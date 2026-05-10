// PROBLEM : Palindrome Pairs

// SOLUTION :

class Solution {
    
    private boolean isPalindrome(String s, int l, int r) {
        
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
    
    public boolean palindromePair(String[] arr) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            
            String s = arr[i];
            int n = s.length();
            
            for (int cut = 0; cut <= n; cut++) {
                
                String left = s.substring(0, cut);
                String right = s.substring(cut);
                
                // If left part is palindrome
                if (isPalindrome(left, 0, left.length() - 1)) {
                    
                    String rev = new StringBuilder(right).reverse().toString();
                    
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }
                
                // If right part is palindrome
                // cut != n avoids duplicate checking
                if (cut != n && isPalindrome(right, 0, right.length() - 1)) {
                    
                    String rev = new StringBuilder(left).reverse().toString();
                    
                    if (map.containsKey(rev) && map.get(rev) != i) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
