// PROBLEM : Finding Profession

// SOLUTION :

class Solution:
    def profession(self, level, pos):
        # code here
        set_bits = bin(pos - 1).count('1')
        
        return 'Engineer' if set_bits % 2 == 0 else 'Doctor'
