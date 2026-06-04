# PROBLEM :Lexicographically smallest after removing k

# SOLUTION :

class Solution:
    def lexicographicallySmallest(self, s, k):
        # code here 
        n = len(s)
        
        if n & (n-1) == 0:
            k //= 2
        else:
            k *= 2
            
        
        if k >= n:
            return "-1"
            
        m = n-k
        st = []
        rem = k
        
        for c in s :
            while st and rem and st[-1] > c:
                st.pop()
                rem -= 1
            st.append(c)
        
        while rem:
            st.pop()
            rem -= 1
            
        
        ans = ''.join(st[:m])
        
        return ans if ans else "-1"
