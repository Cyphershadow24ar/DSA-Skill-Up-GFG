/* PROBLEM : Linked List Group Reverse

You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.
   
Input: k = 4,
Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.
   
Constraints:
1 ≤ size of linked list ≤ 105
0 ≤ node->data ≤ 106
1 ≤ k ≤ size of linked list 
*/

// SOLUTION :

/*
class Node {
  public:
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/
class Solution {
  public:
    Node *reverseKGroup(Node *head, int k) {
        if (!head || k == 1) return head;

        Node *curr = head;
        Node *prev = NULL, *next = NULL;
        int count = 0;

        // Count the total nodes
        Node *temp = head;
        int length = 0;
        while (temp) {
            length++;
            temp = temp->next;
        }

        // Reverse in groups of k
        while (count + k <= length) {
            Node *lastPrev = prev;
            Node *lastCurr = curr;

            // Reverse k nodes
            Node *prevNode = NULL;
            for (int i = 0; i < k; i++) {
                next = curr->next;
                curr->next = prevNode;
                prevNode = curr;
                curr = next;
            }

            // Connect with previous part
            if (lastPrev) {
                lastPrev->next = prevNode;
            } else {
                head = prevNode; // New head for the first group
            }

            lastCurr->next = curr;
            prev = lastCurr;
            count += k;
        }

        // Reverse the remaining nodes (length - count)
        if (count < length) {
            Node *lastPrev = prev;
            Node *lastCurr = curr;

            Node *prevNode = NULL;
            while (curr) {
                next = curr->next;
                curr->next = prevNode;
                prevNode = curr;
                curr = next;
            }

            if (lastPrev) {
                lastPrev->next = prevNode;
            } else {
                head = prevNode;
            }
        }

        return head;
    }
};

