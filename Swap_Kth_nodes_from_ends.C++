/* PROBLEM : Swap Kth nodes from ends

Given the head of a singly linked list and an integer k. Swap the kth node (1-based index) from the beginning and the kth node from the end of the linked list. 
Return the head of the final formed list and if it's not possible to swap the nodes return the original list.

Examples:

Input: k = 1,
Output: 5 -> 2 -> 3 -> 4 -> 1
Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will be 5 -> 2 -> 3 -> 4 -> 1.
  
Input: k = 2,
Output: 5 -> 9 -> 8 -> 5 -> 10 -> 3
Explanation: Here k = 2, hence after swapping the 2nd node from the beginning and end the new list will be 5 -> 9 -> 8 -> 5 -> 10 -> 3.
  
Constraints:
1 ≤ list size ≤ 104
1 ≤ node->data ≤ 106
1 ≤ k ≤ 104
*/

// SOLUTION :

/*
class Node {
  public:
    int data;
    Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
  public:
    Node* swapKth(Node* head, int k) {
        if (!head) return head;

        // Step 1: Find length
        int n = 0;
        Node* temp = head;
        while (temp) {
            n++;
            temp = temp->next;
        }

        // Step 2: If k is invalid
        if (k > n) return head;

        // Step 3: If both are same node
        if (2 * k - 1 == n) return head;

        // Step 4: Find kth node from start and end + their previous nodes
        Node* prevX = nullptr;
        Node* currX = head;
        for (int i = 1; i < k; i++) {
            prevX = currX;
            currX = currX->next;
        }

        Node* prevY = nullptr;
        Node* currY = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = currY;
            currY = currY->next;
        }

        // Step 5: Swap previous pointers
        if (prevX) prevX->next = currY;
        else head = currY;  // if X was head

        if (prevY) prevY->next = currX;
        else head = currX;  // if Y was head

        // Step 6: Swap next pointers
        Node* tempNext = currX->next;
        currX->next = currY->next;
        currY->next = tempNext;

        return head;
    }
};

