// PROBLEM :  Police and Thieves

// SOLTUION :

class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        
        for(int i =0; i< arr.length; i++){
            if(arr[i] == 'P'){
                police.add(i);
            }else{
                thieves.add(i);
            }
        }
        
        int i=0, j=0;
        int count = 0;
        
        while(i < police.size() && j < thieves.size()){
            if(Math.abs(police.get(i) - thieves.get(j)) <= k){
                count++;
                i++;
                j++;
            } else if ( thieves.get(j) < police.get(i)){
                j++;
            }else {
                i++;
            }
        }
        return count;
    }
}
