 // PROBLEM : Maximum Number of People Defeated

// SOLUTION :

class Solution {
    int maxPeopleDefeated(int p) {
        // code here
         int count = 0;
        for(int i = 1; p >= i*i; i++){
             p = p - (i*i);
             count++;
        }
        return count;
    }
};
