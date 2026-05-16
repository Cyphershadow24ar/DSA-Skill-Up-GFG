// PROBLEM : Not a subset sum

// SOLUTION :

class Solution {
    public int findSmallest(int[] arr) {
        // code here
        // 1. Sort 
        Arrays.sort();
        // 2. taking x initalized as value 1 here.
        long x =1;
        
        // looping the array.
        for(int i=0; i<arr.length; i++){
            // arr[i] element greater then x then we found the min which is the ans.
            // this condition gives value in the gap of array like 8 > 7 , in the last element so 7 is the ans.
            if(arr[i] > x){
                return x;
            }
            
            x = x + arr[i]; // updating the value of x util the above condition is satisfied.
        }
        return x; 
        // return 10 if the condition becomes like this 6 > 10 in the last element so ans is 10.
        // if we cannot find the answer from the above condition this will return the maximum and the final ans.
    }
}
