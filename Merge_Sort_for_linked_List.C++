/* PROBLEM : Merge Sort for Linked List
You are given the head of a linked list. You have to sort the given linked list using Merge Sort.

Examples:

Input:
Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60
Explanation: After sorting the given linked list, the resultant list will be:
    
Input:
Output: 2 -> 5 -> 8 -> 9
Explanation: After sorting the given linked list, the resultant list will be:
    
Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 106

SOLUTION :
*/

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
    // Helper function to merge two sorted linked lists
    Node* merge(Node* left, Node* right) {
        if (!left) return right;
        if (!right) return left;
        
        Node* result = nullptr;
        
        if (left->data <= right->data) {
            result = left;
            result->next = merge(left->next, right);
        } else {
            result = right;
            result->next = merge(left, right->next);
        }
        return result;
    }
    
    // Helper function to find the middle of the linked list
    Node* getMiddle(Node* head) {
        if (!head) return head;
        
        Node* slow = head;
        Node* fast = head->next;
        
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }
    
    Node* mergeSort(Node* head) {
        // Base case: empty list or single node
        if (!head || !head->next) {
            return head;
        }
        
        // Get middle of the list
        Node* middle = getMiddle(head);
        Node* nextOfMiddle = middle->next;
        
        // Break the list into two halves
        middle->next = nullptr;
        
        // Recursive calls to sort both halves
        Node* left = mergeSort(head);
        Node* right = mergeSort(nextOfMiddle);
        
        // Merge the sorted halves
        Node* sortedList = merge(left, right);
        
        return sortedList;
    }
};


