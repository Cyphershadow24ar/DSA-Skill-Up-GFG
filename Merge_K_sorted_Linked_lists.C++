/* PROBLEM : Merge K sorted linked lists

Given an array arr[] of n sorted linked lists of different sizes. Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

Examples:

Input:
Output: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9
Explanation: The arr[] has 3 sorted linked list of size 3, 3, 1.
1st list: 1 -> 3 -> 7
2nd list: 2 -> 4 -> 8
3rd list: 9
The merged list will be: 
    
Input:
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation: The arr[] has 3 sorted linked list of size 2, 1, 3.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be: 
    
Constraints
1 ≤ total no. of nodes ≤ 105
1 ≤ node->data ≤ 103

SOLUTION
*/

#include <queue>
using namespace std;

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

// Custom comparator for the priority queue
struct compare {
    bool operator()(Node* a, Node* b) {
        return a->data > b->data;  // Min Heap based on node data
    }
};

class Solution {
  public:
    Node* mergeKLists(vector<Node*>& arr) {
        priority_queue<Node*, vector<Node*>, compare> minHeap;
        
        // Step 1: Push the head of each linked list into the min heap
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] != NULL) {
                minHeap.push(arr[i]);
            }
        }
        
        // Dummy node to simplify list merging
        Node* dummy = new Node(0);
        Node* tail = dummy;
        
        // Step 2: Extract minimum node and push next nodes
        while (!minHeap.empty()) {
            Node* smallest = minHeap.top();
            minHeap.pop();
            
            tail->next = smallest;
            tail = tail->next;
            
            if (smallest->next != NULL) {
                minHeap.push(smallest->next);
            }
        }
        
        return dummy->next;
    }
};
