// PROBLEM : URLify a given string

// SOLUTION :

class Solution {
    String URLify(String s) {
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}
