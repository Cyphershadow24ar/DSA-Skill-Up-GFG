/* PROBLEM : Maximize median after doing k addition operation

Given an array arr[] consisting of positive integers and an integer k. You are allowed to perform at most k operations, where in each operation, you can increment any one element of the array by 1.
Determine the maximum possible median of the array that can be achieved after performing at most k such operations.

Note: The median of a sorted array is the middle element if the size is odd, or the average of the two middle elements if the size is even.

Examples:

Input: arr[] = [1, 3, 4, 5], k = 3
Output: 5
Explanation: We can add +2 to the second element and +1 to the third element to get the array [1, 5, 5, 5]. After sorting, the array remains [1, 5, 5, 5]. Since the length is even, the median is (5 + 5) / 2 = 5.

Input: arr[] = [1, 3, 6, 4, 2], k = 10
Output: 7
Explanation: After applying operations optimally, we can transform the array to [1, 3, 7, 7, 7] (one possible way). Sorted array becomes [1, 3, 7, 7, 7]. Since the length is odd, the median is the middle element 7.

Constraints:
1 ≤ arr.size() ≤ 105
0 ≤ arr[i], k ≤ 109
*/


// SOLUTION :

class Solution {
  public:
    int maximizeMedian(vector<int>& arr, int k) {
        int n = arr.size();
        sort(arr.begin(), arr.end());

        // Min-heap to store candidate median elements
        priority_queue<int, vector<int>, greater<int>> pq;

        if (n % 2 == 0)
            pq.push(arr[n / 2 - 1]);

        for (int i = n / 2; i < n; i++) {
            pq.push(arr[i]);
        }

        // distribute increments optimally
        while (k > 0) {
            int top = pq.top();
            pq.pop();
            pq.push(top + 1);
            k--;
        }

        if (n % 2 == 0) {
            int first = pq.top(); pq.pop();
            int second = pq.top();
            return (first + second) / 2;
        } else {
            return pq.top();
        }
    }
};


