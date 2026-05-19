// PROBLEM : Minimum Multiplications to reach End

// SOLUTION :

import java.util.*;

class Solution {

    int minSteps(int[] arr, int start, int end) {

        Queue<int[]> q = new LinkedList<>();

        int[] dist = new int[1000];

        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(new int[]{start, 0});

        dist[start] = 0;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int num = cur[0];
            int steps = cur[1];

            if (num == end) {
                return steps;
            }

            for (int i = 0; i < arr.length; i++) {

                int next = (num * arr[i]) % 1000;

                if (steps + 1 < dist[next]) {

                    dist[next] = steps + 1;

                    q.offer(new int[]{next, steps + 1});
                }
            }
        }

        return -1;
    }
}
