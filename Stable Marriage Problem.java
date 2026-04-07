// PROBLEM : Stable Marriage Problem

// SOLUTOIN :

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        
        // Precompute women's preferences for O(1) lookups.
        // womenRank[w][m] stores the rank of man 'm' for woman 'w'.
        // Lower rank number means higher preference.
        int[][] womenRank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int rank = 0; rank < n; rank++) {
                int m = women[w][rank];
                womenRank[w][m] = rank;
            }
        }
        
        // Track the current partner of each woman. -1 means free.
        int[] womenPartner = new int[n];
        Arrays.fill(womenPartner, -1);
        
        // Track the index of the next woman a man should propose to in his list.
        int[] nextProposal = new int[n]; 
        
        // Queue to keep track of all currently free men
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.offer(i);
        }
        
        // Process until all men are engaged
        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            
            // Get the next woman on this man's preference list
            int w = men[m][nextProposal[m]];
            nextProposal[m]++; // Increment so he doesn't propose to her again
            
            if (womenPartner[w] == -1) {
                // Woman is free, she accepts the proposal
                womenPartner[w] = m;
            } else {
                int mPrime = womenPartner[w];
                // Woman is already engaged, check if she prefers the new man 'm' over her current 'mPrime'
                if (womenRank[w][m] < womenRank[w][mPrime]) {
                    // She prefers the new man, they get engaged
                    womenPartner[w] = m;
                    // The old partner becomes free again
                    freeMen.offer(mPrime);
                } else {
                    // She rejects the new man, he remains free and tries his next option later
                    freeMen.offer(m);
                }
            }
        }
        
        // Construct the final result array from the men's perspective
        int[] result = new int[n];
        for (int w = 0; w < n; w++) {
            if (womenPartner[w] != -1) {
                result[womenPartner[w]] = w; // The man `womenPartner[w]` is matched with woman `w`
            }
        }
        
        return result;
    }
}
