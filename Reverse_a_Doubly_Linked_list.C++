/* PROBLEM : Reverse a Doubly Linked List

You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104
*/

// SOLUTION :

/*
class Node {
  public:
    int data;
    Node *next;
    Node *prev;
    Node(int val) {
        data = val;
        next = NULL;
        prev = NULL;
    }
};

*/
class Solution {
  public:
    Node *reverse(Node *head) {
        if (!head || !head->next) return head; // 0 or 1 node → no change

        Node* curr = head;
        Node* prevNode = NULL;

        while (curr != NULL) {
            // Swap prev and next
            Node* temp = curr->prev;
            curr->prev = curr->next;
            curr->next = temp;

            // Move to "next" (which is actually the old prev)
            prevNode = curr;
            curr = curr->prev;
        }

        // prevNode will now be the new head
        return prevNode;
    }
};
