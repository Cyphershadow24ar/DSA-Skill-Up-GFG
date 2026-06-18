# PROBLEM : Coverage of all Zeros in a Binary Matrix

# SOLUTION :

class Solution:
      def findCoverage(self, mat):
        m, n = len(mat), len(mat[0])

        def count_coverage(itr):
            coverage = 0
            has_one = False
            for cell in itr:
                if cell:
                    has_one = True
                elif has_one:
                    coverage += 1
            return coverage

        coverage = 0
        for row in mat:
            coverage += count_coverage(row)
            coverage += count_coverage(reversed(row))
        for col_i in range(n):
            coverage += count_coverage(mat[row_i][col_i] for row_i in range(m))
            coverage += count_coverage(mat[row_i][col_i] for row_i in reversed(range(m)))
        return coverage
        
