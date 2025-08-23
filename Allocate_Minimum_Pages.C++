/* PROBLEM : Allocate Minimum Pages

Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book.
You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. 
In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.

Note: If it is not possible to allocate books to all students, return -1.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.

Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 103
*/

// SOLUTION : 

class Solution {
  public:
    // Helper function to check if allocation is possible
    bool isPossible(vector<int>& arr, int k, int mid) {
        int students = 1;  // count of students
        int pages = 0;     // pages assigned to current student
        
        for (int pagesInBook : arr) {
            if (pages + pagesInBook > mid) {
                students++;        // allocate to next student
                pages = pagesInBook;
                
                if (students > k) return false; // more students needed
            } else {
                pages += pagesInBook;
            }
        }
        return true;
    }
    
    int findPages(vector<int> &arr, int k) {
        int n = arr.size();
        if (k > n) return -1; // Not enough books for students
        
        int low = *max_element(arr.begin(), arr.end()); // max single book
        int high = accumulate(arr.begin(), arr.end(), 0); // sum of all
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, k, mid)) {
                ans = mid;    // possible, store result
                high = mid - 1; // try smaller maximum
            } else {
                low = mid + 1; // not possible, increase limit
            }
        }
        return ans;
    }
};

