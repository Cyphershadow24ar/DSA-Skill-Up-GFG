# Problem : Largest Rectangle with Column Swaps

# Solution : 

class Solution:
    def maxArea(self, mat: list[list[int]]) -> int:
        # code here
        n = len(mat[0])
        heights = [0] * n
        max_area = 0
        for row in mat:
            for i in range(n):
                heights[i] = heights[i] + 1 if row[i] else 0
            sheights = sorted(filter(None, heights), reverse=True)
            for j in range(len(sheights)):
                max_area = max(max_area, sheights[j] * (j + 1))
        return max_area
