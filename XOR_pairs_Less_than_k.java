// PROBLEM : XOR Pairs less than K

// SOLUTION :

class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int cnt = 0;
    }

    TrieNode root;

    // Insert number into the trie
    private void insert(int num) {
        TrieNode cur = root;
        for (int b = 15; b >= 0; b--) {
            int bit = (num >> b) & 1;
            if (cur.child[bit] == null) cur.child[bit] = new TrieNode();
            cur = cur.child[bit];
            cur.cnt++;
        }
    }

    // Count numbers already inserted such that (num XOR y) < k
    private int countLess(int num, int k) {
        TrieNode cur = root;
        int ans = 0;

        for (int b = 15; b >= 0; b--) {
            if (cur == null) break;

            int bitX = (num >> b) & 1;
            int bitK = (k   >> b) & 1;

            if (bitK == 1) {
                // Case 1: XOR bit = 0 → choose same bitX, add subtree count
                if (cur.child[bitX] != null) {
                    ans += cur.child[bitX].cnt;
                }

                // Case 2: follow branch which gives XOR=1
                cur = cur.child[1 - bitX];
            } else {
                // Must follow XOR=0 → same bitX
                cur = cur.child[bitX];
            }
        }

        return ans;
    }

    public int cntPairs(int[] arr, int k) {
        root = new TrieNode();
        int total = 0;

        for (int x : arr) {
            total += countLess(x, k);  // count valid pairs with previous elements
            insert(x);                 // insert current element
        }

        return total;
    }
}
