# PROBLEM : Equal Point in Brackets

# SOLUTION :

class Solution:
    def findIndex(self, s):
        # code here 
        closeRight = s.count(')')
        openLeft = 0

        for k in range(len(s) + 1):
            if openLeft == closeRight:
                return k

            if k < len(s):
                if s[k] == '(':
                    openLeft += 1
                else:
                    closeRight -= 1

        return len(s)


