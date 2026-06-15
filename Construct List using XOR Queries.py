# PROBLEM : Construct List using XOR Queries

# SOLUTION :

class Solution:
    def constructList(self, queries):
        res = []
        cumulative_xor = 0
        
        # Traverse queries in reverse order
        for i in range(len(queries) - 1, -1, -1):
            q_type = queries[i][0]
            val = queries[i][1]
            
            if q_type == 1:
                # Accumulate the XOR value for all prior elements
                cumulative_xor ^= val
            else:
                # For insertions, apply the accumulated XOR right away
                res.append(val ^ cumulative_xor)
                
        # The initial element 0 experiences all type 1 queries
        res.append(0 ^ cumulative_xor)
        
        # Sort the final array as required by the problem
        res.sort()
        return res
