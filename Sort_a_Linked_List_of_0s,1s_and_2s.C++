/* PROBLEM : Sort a linked list of 0s, 1s and 2s

Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. 
Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2
*/

// SOLUTION:

/* Node is defined as
  class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};
*/
class Solution {
  public:
    Node* segregate(Node* head) {
        if (!head || !head->next) return head;
        
        // Dummy heads and tails for 0s, 1s, and 2s lists
        Node* zeroHead = new Node(-1), *zeroTail = zeroHead;
        Node* oneHead  = new Node(-1), *oneTail  = oneHead;
        Node* twoHead  = new Node(-1), *twoTail  = twoHead;
        
        // Traverse original list
        Node* curr = head;
        while (curr) {
            if (curr->data == 0) {
                zeroTail->next = curr;
                zeroTail = zeroTail->next;
            } 
            else if (curr->data == 1) {
                oneTail->next = curr;
                oneTail = oneTail->next;
            } 
            else {
                twoTail->next = curr;
                twoTail = twoTail->next;
            }
            curr = curr->next;
        }
        
        // Merge lists: 0s → 1s → 2s
        zeroTail->next = (oneHead->next) ? oneHead->next : twoHead->next;
        oneTail->next  = twoHead->next;
        twoTail->next  = nullptr; // end of list
        
        // New head
        head = zeroHead->next;
        
        // cleanup dummy nodes
        delete zeroHead;
        delete oneHead;
        delete twoHead;
        
        return head;
    }
};

