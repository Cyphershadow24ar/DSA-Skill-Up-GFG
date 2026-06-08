# PROBLEM : Seating Arrangement

# SOLUTION :

class Solution:
    def canSeatAllPeople(self, k, seats):
        n = len(seats)

        for i in range(n):
            if seats[i] == 0:
                l = (i == 0 or seats[i - 1] == 0)
                r = (i == n - 1 or seats[i + 1] == 0)

                if l and r:
                    seats[i] = 1
                    k -= 1

                    if k == 0:
                        return True

        return k <= 0
