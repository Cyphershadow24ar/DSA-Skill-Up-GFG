// PROBLEM : Isomorphic Strings

// SOLUTION :

class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        for(int i=0; i<s1.length() ; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if(map1[c1 - 'a'] == 0 && map2[c2 - 'a'] == 0){
                map1[c1 - 'a'] = c2;
                map2[c2 - 'a'] = c1;
            }
            else{
                if (map1[c1 - 'a'] != c2 || map2[c2 - 'a'] != c1){
                    return false;
                }
            }
        }
        return true;
    }
}
