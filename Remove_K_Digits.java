// PROBLEM : Remove K Digits

// SOLUTION : 

class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n =s.length(); // string ka length
        
        StringBuilder stack = new StringBuilder(); // to keep digits in increasing order.
        
        for(int i =0; i<n ; i++){
            char c = s.charAt(i);
            
            //Remove larger digits from the end
            while(k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c){
                stack.deleteCharAt(stack.length() -1);
                k--;
            }
            stack.append(c);
        }
        
        // If still removals left, remove from end
        while(k > 0 && stack.length() > 0){
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        // remove leading zero left in the string in the front !
        
        int id = 0;
        while(id < stack.length() && stack.charAt(id) == '0'){
            id++;
        }
        String result = stack.substring(id);
        
        return result.length() == 0 ? "0" : result;
    }
}
