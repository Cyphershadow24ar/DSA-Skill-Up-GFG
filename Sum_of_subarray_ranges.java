// PROBLEM : Sum of subarray ranges

// SOLUTION :

class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;

        long maxSum = 0;
        long minSum = 0;

        // ---------- Maximum Contribution ----------
        int[] leftGreater = new int[n];
        int[] rightGreater = new int[n];

        java.util.Stack<Integer> st = new java.util.Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            leftGreater[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            rightGreater[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxSum += (long) arr[i] * leftGreater[i] * rightGreater[i];
        }

        // ---------- Minimum Contribution ----------
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        st.clear();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            leftSmaller[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            rightSmaller[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            minSum += (long) arr[i] * leftSmaller[i] * rightSmaller[i];
        }

        return (int)(maxSum - minSum);
    }
}
