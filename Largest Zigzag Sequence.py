# PROBLEM : Largest Zigzag Sequence

# SOLUTION :

class Solution:
    def zigzagSequence(self, mat):
        # code here
        n = len(mat)

        # First row: sequence can start from any column
        dp = mat[0][:]

        for i in range(1, n):
            # Find largest and second largest values in previous row
            max1 = max2 = float('-inf')
            idx1 = -1

            for j in range(n):
                if dp[j] > max1:
                    max2 = max1
                    max1 = dp[j]
                    idx1 = j
                elif dp[j] > max2:
                    max2 = dp[j]

            new_dp = [0] * n

            for j in range(n):
                # Cannot use the same column as the previous row
                if j == idx1:
                    best = max2
                else:
                    best = max1

                new_dp[j] = mat[i][j] + best

            dp = new_dp

        return max(dp)
