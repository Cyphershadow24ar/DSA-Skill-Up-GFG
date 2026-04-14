// PROBLEM : Remove Spaces

// SOLUTOIN :

class Solution {
    String removeSpaces(String s) {
        // code here
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c != ' '){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
