// PROBLEM : Minimum cost to connect all houses in a city

// SOLUTION :

import java.util.*;

class Solution {
    public int minCost(int[][] houses) {
        int n = houses.length;
        if (n <= 1) return 0;

        // minDist[i] stores the minimum cost to connect house i to the current MST
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        
        boolean[] inMST = new boolean[n];
        int totalCost = 0;
        int edgesConnected = 0;
        
        // Start with the first house
        minDist[0] = 0;

        // We need to connect n houses, so we need n iterations
        for (int i = 0; i < n; i++) {
            int currHouse = -1;

            // Find the house with the smallest minDist that isn't in the MST yet
            for (int j = 0; j < n; j++) {
                if (!inMST[j] && (currHouse == -1 || minDist[j] < minDist[currHouse])) {
                    currHouse = j;
                }
            }

            // Add this house to MST
            inMST[currHouse] = true;
            totalCost += minDist[currHouse];
            edgesConnected++;

            // Update distances to all other houses from the newly added house
            for (int nextHouse = 0; nextHouse < n; nextHouse++) {
                if (!inMST[nextHouse]) {
                    int dist = Math.abs(houses[currHouse][0] - houses[nextHouse][0]) + 
                               Math.abs(houses[currHouse][1] - houses[nextHouse][1]);
                    
                    if (dist < minDist[nextHouse]) {
                        minDist[nextHouse] = dist;
                    }
                }
            }
        }

        return totalCost;
    }
}
