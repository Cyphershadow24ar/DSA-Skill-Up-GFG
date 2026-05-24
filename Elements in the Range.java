// PROBLEM : Elements in the Range

// SOLUTION :

class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        Set<Integer>  s = new HashSet<>();
        for(int x : arr){
            s.add(x);
        }
        
        for(int i = start ;  i<= end; i++){
            if(!s.contains(i)){
                return false;
            }
        }
        return true;
    }
}
