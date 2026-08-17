// PROBLEM : Snake and Ladder Problem

// SOLUTION :

using System;
using System.Collections.Generic;

public class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int totalCells = n * n;

        // moves[i] stores the destination cell when landing on cell i
        int[] moves = new int[totalCells + 1];
        for (int i = 1; i <= totalCells; i++) {
            moves[i] = i;
        }

        // Populate ladders
        for (int i = 0; i < lad.Length; i += 2) {
            moves[lad[i]] = lad[i + 1];
        }

        // Populate snakes
        for (int i = 0; i < sn.Length; i += 2) {
            moves[sn[i]] = sn[i + 1];
        }

        // Queue stores (current_cell, throws_count)
        Queue<(int cell, int dist)> queue = new Queue<(int cell, int dist)>();
        bool[] visited = new bool[totalCells + 1];

        queue.Enqueue((1, 0));
        visited[1] = true;

        while (queue.Count > 0) {
            var (cell, dist) = queue.Dequeue();

            if (cell == totalCells) {
                return dist;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nextCell = cell + dice;

                if (nextCell <= totalCells) {
                    int destination = moves[nextCell];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.Enqueue((destination, dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}
