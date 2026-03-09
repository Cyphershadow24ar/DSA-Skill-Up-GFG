// PROBLEM : Subarrays with First Element Minimum

// SOLUTION :

class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long count = 0;
        
        for(int i=n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            int nextSmaller;
            
            if(stack.isEmpty()){
                nextSmaller = n;
            }else{
                nextSmaller = stack.peek();
            }
            
            count += (nextSmaller - i);
            
            stack.push(i);
        }
        return (int)count;
    }
}
