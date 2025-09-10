/* PROBLEM : Largest number in one swap

Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

Examples:

Input: s = "768"
Output: "867"
Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.

Input: s = "333"
Output: "333"
Explanation: Performing any swaps gives the same result i.e "333".

Constraints:
1 ≤ |s| ≤ 105
'0' ≤ s[i] ≤ '9'

*/

// SOLUTION :

#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string largestSwap(string &s) {
        int n = s.size();
        vector<int> lastPos(10, -1);

        // Record the last position of each digit
        for (int i = 0; i < n; i++) {
            lastPos[s[i] - '0'] = i;
        }

        // Try to find a better swap
        for (int i = 0; i < n; i++) {
            for (int d = 9; d > s[i] - '0'; d--) {
                if (lastPos[d] > i) {
                    // Swap the characters
                    swap(s[i], s[lastPos[d]]);
                    return s;
                }
            }
        }

        // No swap needed, return original string
        return s;
    }
};
