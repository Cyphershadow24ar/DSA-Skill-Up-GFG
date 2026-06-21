# PROBLEM : Maximum Area Between Bars

# SOLUTION :

class Solution:
    def maxArea(self, height):
        # code here
        n  = len(height)
        if  n <= 2:
            return 0
        l = 0
        r = n-1
        ans = 0
        while l<r+1:
            ans = max(ans, min(height[l],height[r]) * (r-l-1))
            if height[l] <= height[r]:
                l+=1
            else:
                r -= 1
        
        return ans
